package com.radhika.fueldistributionsystemSchedule.Listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radhika.fueldistributionsystemSchedule.Model.ReservedStock;
import com.radhika.fueldistributionsystemSchedule.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {

    @Autowired
    ScheduleService scheduleService;


    @KafkaListener(topics = "inventoryTopic", groupId = "sample-group")
    public void consumeJson(@Payload List<ReservedStock> data){

        String value = String.valueOf(data);
        String orderNo = "";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<ReservedStock> reservedOrders = objectMapper.readValue(value, new TypeReference<List<ReservedStock>>(){});
            for(ReservedStock order : reservedOrders) {
                orderNo  = order.getOrderNo();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(scheduleService.deliveryDateByOrderNo(orderNo));

    }

}
