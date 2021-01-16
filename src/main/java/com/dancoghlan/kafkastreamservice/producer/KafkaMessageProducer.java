package com.dancoghlan.kafkastreamservice.producer;

import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer implements MessageProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;

    @Autowired
    public KafkaMessageProducer(@NotNull KafkaTemplate<String, String> kafkaTemplate,
                                @NotNull @Value("${kafka.topic1}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
        logger.info("Sending message to topic [{}]", topicName);
    }

}
