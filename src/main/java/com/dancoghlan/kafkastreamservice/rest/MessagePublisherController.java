package com.dancoghlan.kafkastreamservice.rest;

import com.dancoghlan.kafkastreamservice.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest")
public class MessagePublisherController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        messageProducer.sendMessage(message);
        return ResponseEntity.ok("Published message");
    }

    @PostMapping("/publish/{numMessages}")
    public ResponseEntity<String> publishMessage(@PathVariable int numMessages) {
        for (int i = 0; i < numMessages; i++) {
            String message = "message " + i;
            messageProducer.sendMessage(message);
        }
        return ResponseEntity.ok("Published message");
    }

}
