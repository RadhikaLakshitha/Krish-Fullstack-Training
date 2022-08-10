package com.radhika.fueldistributionsystemInventory.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AvailableStock")
public class AvailableStock {


    @Id
    private int id;
    private int availability;
    private String fuelType;


    public AvailableStock() {
    }

    public AvailableStock(int id, int availability, String fuelType) {
        this.id = id;
        this.availability = availability;
        this.fuelType = fuelType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Available Stock [id=" + id + ", FuelType=" + fuelType + ", Availability =" + availability + "]";
    }
}
