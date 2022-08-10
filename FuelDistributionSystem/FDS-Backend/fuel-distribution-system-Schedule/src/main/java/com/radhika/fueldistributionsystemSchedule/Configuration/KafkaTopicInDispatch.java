package com.radhika.fueldistributionsystemSchedule.Configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicInDispatch {

    public static final String MESSAGE_TOPIC = "scheduleDispatchTopic";

    @Bean
    public NewTopic myTopicDispatch(){
        return TopicBuilder.name(MESSAGE_TOPIC)
                .build();
    }
}
