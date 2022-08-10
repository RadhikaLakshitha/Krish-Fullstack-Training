package com.radhika.fueldistributionsystemDispatch.Listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radhika.fueldistributionsystemDispatch.Model.Dispatch;
import com.radhika.fueldistributionsystemDispatch.Service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {

    @Autowired
    DispatchService dispatchService;

    @KafkaListener(topics = "scheduleDispatchTopic", groupId = "sample-group")
    public void consumeJson(@Payload List<Dispatch> data){

        String value = String.valueOf(data);
        String orderNo = "";
        String date = "";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Dispatch> reservedOrders = objectMapper.readValue(value, new TypeReference<List<Dispatch>>(){});
            for(Dispatch order : reservedOrders) {
                orderNo  = order.getOrderNo();
                date = order.getDate();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(dispatchService.dispatchDelivery(orderNo, date));

    }
}
