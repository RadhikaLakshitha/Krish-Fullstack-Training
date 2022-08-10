package com.radhika.fueldistributionsystemDispatch.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "Dispatch")
public class Dispatch {

    //private String getDate = LocalDate.now().plusDays(1).toString();

    @Id
    private String orderNo;
    private String date ;

    public Dispatch() {
    }

    public Dispatch(String orderNo, String date) {
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
