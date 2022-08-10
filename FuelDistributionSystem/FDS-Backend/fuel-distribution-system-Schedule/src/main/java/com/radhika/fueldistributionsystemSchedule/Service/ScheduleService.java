package com.radhika.fueldistributionsystemSchedule.Service;


import com.radhika.fueldistributionsystemSchedule.Model.Schedule;

import java.util.List;


public interface ScheduleService {

    public Schedule saveSchedule(Schedule schedule);

    public Schedule deliveryDateByOrderNo(String OrderNo);

    public List<Schedule> getAllDeliveries();
}
