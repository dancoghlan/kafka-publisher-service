package com.dancoghlan.kafkastreamservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "${kafka.topic1}", groupId = "group-id")
public class KafkaSourceMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(KafkaSourceMessageListener.class);

    @Value("${kafka.topic1}")
    private String topic1;

    @Value("${kafka.topic2}")
    private String topic2;

    @KafkaHandler
    @SendTo("${kafka.topic2}")
    public String listen(String message) {
        logger.info("Received message on [{}]: [{}]", topic1, message);
        logger.info("Sending message to [{}]", topic2);
        return message;
    }

}
