package com.radhika.fueldistributionsystemOrder.Listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radhika.fueldistributionsystemOrder.Model.ReservedStock;
import com.radhika.fueldistributionsystemOrder.Model.Schedule;
import com.radhika.fueldistributionsystemOrder.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {

    @Autowired
    OrderService orderService;

    @KafkaListener(topics = "scheduleTopic", groupId = "sample-group")
    public void consumeJson(@Payload List<Schedule> data){


        String value = String.valueOf(data);
        String orderNo = "";
        String status = "Allocated";
        String date = "";


        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Schedule> orders = objectMapper.readValue(value, new TypeReference<List<Schedule>>(){});
            for(Schedule order : orders) {
                orderNo  = order.getOrderNo();
                date = order.getDate();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        orderService.orderReceived(orderNo, status, date);

    }


}
