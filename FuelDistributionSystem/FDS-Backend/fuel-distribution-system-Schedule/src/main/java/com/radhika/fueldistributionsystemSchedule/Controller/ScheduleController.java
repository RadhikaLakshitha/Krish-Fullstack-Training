package com.radhika.fueldistributionsystemSchedule.Controller;

import com.radhika.fueldistributionsystemSchedule.Model.Schedule;
import com.radhika.fueldistributionsystemSchedule.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {


    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/allDeliveries")
    public List<Schedule>getAllDeliveries(){
       return scheduleService.getAllDeliveries();
    }

    @GetMapping("/deliveryDate/{OrderNO}")
    public Schedule deliveryDateByOrderNo(@PathVariable String OrderNo){
        return scheduleService.deliveryDateByOrderNo(OrderNo);
    }
}
