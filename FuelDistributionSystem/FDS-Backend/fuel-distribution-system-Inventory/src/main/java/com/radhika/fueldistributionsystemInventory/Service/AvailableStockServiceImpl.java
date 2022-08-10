package com.radhika.fueldistributionsystemInventory.Service;

import com.radhika.fueldistributionsystemInventory.Model.AvailableStock;
import com.radhika.fueldistributionsystemInventory.Repository.AvailableStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AvailableStockServiceImpl implements AvailableStockService{

    @Autowired
    AvailableStockRepository availableStockRepository;

    @Autowired
    ReservedStockService reservedStockService;

    @Override
    public ResponseEntity<AvailableStock> saveAvailableStock(AvailableStock availableStock) {

        try {
            availableStockRepository.save(availableStock);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        return ResponseEntity.status(HttpStatus.OK).body(availableStock);
    }

    @Override
    public AvailableStock getCapacity(String fuelType, int fuelCapacity, String orderNo) {

        AvailableStock fromFuelType =availableStockRepository.findByFuelType(fuelType);
        int stockCapacity = fromFuelType.getAvailability();
        String status = "Allocated";

        //after confirmed the order

        if(stockCapacity>=fuelCapacity) {
            int availableCapacity = stockCapacity - fuelCapacity;
            fromFuelType.setAvailability(availableCapacity);
            saveAvailableStock(fromFuelType);
            reservedStockService.getFromAvailableStock(orderNo, fuelType, fuelCapacity);

        }

        return fromFuelType;
    }
}
