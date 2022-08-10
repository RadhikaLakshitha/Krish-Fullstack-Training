package com.radhika.fueldistributionsystemInventory.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "Order")
public class Order {

    private String date = LocalDate.now().toString();

    @Transient

    private UUID orderId = UUID.randomUUID();

    @Id
    private String orderNo = orderId.toString();
    private String id;
    private String name;
    private String address;
    private int capacity;
    private String fuelType;
    private String status = "Pending";
    private String today = date;
    private String scheduleDate = "Pending";

    public Order() {
    }

    public Order( String orderNo, String id, String name, String address, int capacity, String fuelType, String status, String today, String scheduleDate) {

        this.orderNo = orderNo;
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.status = status;
        this.today = today;
        this.scheduleDate=scheduleDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
