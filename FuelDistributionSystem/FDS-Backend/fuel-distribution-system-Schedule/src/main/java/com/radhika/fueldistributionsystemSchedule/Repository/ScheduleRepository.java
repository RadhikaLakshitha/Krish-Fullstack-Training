package com.radhika.fueldistributionsystemSchedule.Repository;

import com.radhika.fueldistributionsystemSchedule.Model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
}
