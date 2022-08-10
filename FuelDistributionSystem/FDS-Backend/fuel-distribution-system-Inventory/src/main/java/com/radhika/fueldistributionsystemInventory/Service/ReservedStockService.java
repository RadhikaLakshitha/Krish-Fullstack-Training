package com.radhika.fueldistributionsystemInventory.Service;

import com.radhika.fueldistributionsystemInventory.Model.ReservedStock;

public interface ReservedStockService {

    public ReservedStock saveReservedStock(ReservedStock reservedStock);
    public ReservedStock getFromAvailableStock(String orderNo, String fuelType, int fuelCapacity);
}
