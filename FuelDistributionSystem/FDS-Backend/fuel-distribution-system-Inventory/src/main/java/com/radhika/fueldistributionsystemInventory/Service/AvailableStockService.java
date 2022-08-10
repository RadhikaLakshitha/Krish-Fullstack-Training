package com.radhika.fueldistributionsystemInventory.Service;

import com.radhika.fueldistributionsystemInventory.Model.AvailableStock;
import org.springframework.http.ResponseEntity;

public interface AvailableStockService {

    public ResponseEntity<AvailableStock>saveAvailableStock(AvailableStock availableStock);

    public AvailableStock getCapacity(String fuelType, int fuelCapacity, String orderNo);
}
