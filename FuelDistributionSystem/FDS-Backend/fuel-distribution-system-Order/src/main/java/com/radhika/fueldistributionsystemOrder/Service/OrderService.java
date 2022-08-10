package com.radhika.fueldistributionsystemOrder.Service;

import com.radhika.fueldistributionsystemOrder.Model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public ResponseEntity<Order> submitOrder(Order order);

    public ResponseEntity<List<Order>>getAllOrders();

   // public ResponseEntity<Optional<Order>> getOrderById(String id);

    public ResponseEntity<Optional<Order>> getOrderByOrderNo(String OrderNo);

    public ResponseEntity<Order> orderReceived(String orderNo, String status);

    public ResponseEntity<Order> orderReceived(String orderNo, String status, String date);



}
