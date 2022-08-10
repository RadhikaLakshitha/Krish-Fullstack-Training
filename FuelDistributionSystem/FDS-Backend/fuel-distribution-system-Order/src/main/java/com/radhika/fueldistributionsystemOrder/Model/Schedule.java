package com.radhika.fueldistributionsystemOrder.Model;

public class Schedule {

    private String orderNo;
    private String date;


    public Schedule() {
    }

    public Schedule(String orderNo, String date) {
        this.orderNo = orderNo;
        this.date = date;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
