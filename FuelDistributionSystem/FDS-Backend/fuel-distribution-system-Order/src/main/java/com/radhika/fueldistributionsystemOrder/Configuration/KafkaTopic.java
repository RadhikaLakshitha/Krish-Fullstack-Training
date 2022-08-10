package com.radhika.fueldistributionsystemOrder.Configuration;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    public static final String MESSAGE_TOPIC = "orderTopic";


    @Bean
    public NewTopic myTopic(){
        return TopicBuilder.name(MESSAGE_TOPIC).build();
    }

}
