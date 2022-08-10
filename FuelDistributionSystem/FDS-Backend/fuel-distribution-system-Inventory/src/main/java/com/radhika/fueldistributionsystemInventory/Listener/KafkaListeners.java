package com.radhika.fueldistributionsystemInventory.Listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radhika.fueldistributionsystemInventory.Model.Order;
import com.radhika.fueldistributionsystemInventory.Service.AvailableStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {

    @Autowired
    AvailableStockService availableStockService;



    @KafkaListener(topics = "orderTopic", groupId = "sample-group")
    public void consumeJson(@Payload List<Order> data){

       // System.out.println(data);
        String value = String.valueOf(data);
        String fuelType = "";
        String status = "";
        String orderNo = "";
        int fuelCapacity = 0;

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Order> orders = objectMapper.readValue(value, new TypeReference<List<Order>>(){});
            for(Order order : orders) {
                fuelType = order.getFuelType();
                fuelCapacity = order.getCapacity();
                status = order.getStatus();
                orderNo  = order.getOrderNo();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        availableStockService.getCapacity(fuelType,fuelCapacity,orderNo);

    }
}
