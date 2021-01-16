package com.dancoghlan.kafkastreamservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "${kafka.topic2}", groupId = "group-id")
public class KafkaTargetMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(KafkaTargetMessageListener.class);

    @Value("${kafka.topic2}")
    private String topic2;

    @KafkaHandler
    public void listen(String message) {
        logger.info("Received message on [{}]: [{}]", topic2, message);
    }

}
