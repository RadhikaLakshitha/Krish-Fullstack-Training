package com.radhika.fueldistributionsystemOrder.Controller;


import com.radhika.fueldistributionsystemOrder.Model.Order;
import com.radhika.fueldistributionsystemOrder.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping
    public ResponseEntity<Order> submitOrder(@RequestBody Order order){

        return orderService.submitOrder(order);

    }

    @GetMapping
    public ResponseEntity<List<Order>>getAllOrders(){
        return  orderService.getAllOrders();
    }


    @GetMapping("/getOrderNo/{orderNo}")
    public ResponseEntity<Optional<Order>> getOrderByOrderNo(@PathVariable String orderNo){
        return  orderService.getOrderByOrderNo(orderNo);
    }

    @PutMapping("/{orderNo}/{status}")
    public ResponseEntity<Order> orderReceived(@PathVariable String orderNo, @PathVariable String status) {
        return orderService.orderReceived(orderNo,status);
    }



}
