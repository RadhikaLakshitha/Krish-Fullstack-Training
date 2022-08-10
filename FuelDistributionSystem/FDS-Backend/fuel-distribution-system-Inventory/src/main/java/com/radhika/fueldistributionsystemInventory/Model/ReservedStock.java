package com.radhika.fueldistributionsystemInventory.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReservedStock")
public class ReservedStock {

    @Id
    private String orderNo;
    private int availability;
    private String fuelType;

    public ReservedStock() {
    }

    public ReservedStock(String orderNo, int availability, String fuelType) {
        this.orderNo = orderNo;
        this.availability = availability;
        this.fuelType = fuelType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
