package com.radhika.fueldistributionsystemOrder.Service;


import com.radhika.fueldistributionsystemOrder.Configuration.KafkaTopic;
import com.radhika.fueldistributionsystemOrder.Model.Order;
import com.radhika.fueldistributionsystemOrder.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public ResponseEntity<Order> submitOrder(Order order) {

        try {

            kafkaTemplate.send(KafkaTopic.MESSAGE_TOPIC, order);
            orderRepository.save(order);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findAll());
    }


//    @Override
//    public ResponseEntity<Optional<Order>> getOrderById(String Id) {
//        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findById(Id));
//    }

    @Override
    public ResponseEntity<Optional<Order>> getOrderByOrderNo(String OrderNo) {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findByOrderNo(OrderNo));
    }

    @Override
    public ResponseEntity<Order> orderReceived(String orderNo, String status) {

        Optional<Order> byId = orderRepository.findById(orderNo);
        if(byId.isPresent()) {
            Order order = byId.get();
            order.setStatus(status);

            orderRepository.save(order);

            return ResponseEntity.status(HttpStatus.OK).body(order);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Order> orderReceived(String orderNo, String status, String date) {

        Optional<Order> byId = orderRepository.findById(orderNo);
        if(byId.isPresent()) {
            Order order = byId.get();
            order.setStatus(status);
            order.setScheduleDate(date);

            orderRepository.save(order);

            return ResponseEntity.status(HttpStatus.OK).body(order);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
