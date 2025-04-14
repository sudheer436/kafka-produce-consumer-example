package com.javatechie.consumer;

import com.javatechie.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);


    @KafkaListener(topics = "first_topic",groupId = "st-group")
    public void consumeEvent1(String value) {
        log.info("consumer consume the events =======>  ", value);
    }

    // This is used to consume the message from specific partition
   /* @KafkaListener(topics = "first_topic",groupId = "st-group",
            topicPartitions = @TopicPartition(topic = "first_topic", partitions = {"2"}))
    public void consumeEvent1(String value) {
        log.info("consumer consume the events =======>  ", value);
    }*/

    @KafkaListener(topics = "custom_topic",groupId = "st-group")
    public void consumeEvent2(Customer customer) {
        log.info("consumer consume the events {} ", customer.toString());
    }

//    @KafkaListener(topics = "javatechie-demo1",groupId = "jt-group-new")
//    public void consume2(String message) {
//        log.info("consumer2 consume the message {} ", message);
//    }
//
//    @KafkaListener(topics = "javatechie-demo1",groupId = "jt-group-new")
//    public void consume3(String message) {
//        log.info("consumer3 consume the message {} ", message);
//    }
//
//    @KafkaListener(topics = "javatechie-demo1",groupId = "jt-group-new")
//    public void consume4(String message) {
//        log.info("consumer4 consume the message {} ", message);
//    }
}
