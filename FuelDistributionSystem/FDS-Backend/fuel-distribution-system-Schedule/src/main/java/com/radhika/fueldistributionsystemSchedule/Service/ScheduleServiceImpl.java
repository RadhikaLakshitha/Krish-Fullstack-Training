package com.radhika.fueldistributionsystemSchedule.Service;

import com.radhika.fueldistributionsystemSchedule.Configuration.KafkaTopic;
import com.radhika.fueldistributionsystemSchedule.Configuration.KafkaTopicInDispatch;
import com.radhika.fueldistributionsystemSchedule.Model.Schedule;
import com.radhika.fueldistributionsystemSchedule.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    KafkaTemplate<String, Schedule> kafkaTemplate;

    @Override
    public Schedule saveSchedule(Schedule schedule) {

        kafkaTemplate.send(KafkaTopic.MESSAGE_TOPIC,schedule);
        kafkaTemplate.send(KafkaTopicInDispatch.MESSAGE_TOPIC,schedule);
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule deliveryDateByOrderNo(String OrderNo) {

        Schedule schedule = new Schedule();
        schedule.setOrderNo(OrderNo);
        schedule.setDate(LocalDate.now().plusDays(1).toString());
        saveSchedule(schedule);
        return schedule;
    }

    @Override
    public List<Schedule> getAllDeliveries() {
        return scheduleRepository.findAll();
    }
}
