package com.radhika.fueldistributionsystemInventory.Service;

import com.radhika.fueldistributionsystemInventory.Configuration.KafkaTopic;
import com.radhika.fueldistributionsystemInventory.Model.ReservedStock;
import com.radhika.fueldistributionsystemInventory.Repository.ReservedStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservedStockServiceImpl implements ReservedStockService{

    @Autowired
    ReservedStockRepository reservedStockRepository;

    @Autowired
    KafkaTemplate<String, ReservedStock> kafkaTemplate;

    @Override
    public ReservedStock saveReservedStock(ReservedStock reservedStock) {

        kafkaTemplate.send(KafkaTopic.MESSAGE_TOPIC,reservedStock);
        return reservedStockRepository.save(reservedStock);
    }

    @Override
    public ReservedStock getFromAvailableStock(String orderNo, String fuelType, int fuelCapacity) {

        ReservedStock reservedStock = new ReservedStock();
        reservedStock.setOrderNo(orderNo);
        reservedStock.setFuelType(fuelType);
        reservedStock.setAvailability(fuelCapacity);

        return saveReservedStock(reservedStock);
    }
}
