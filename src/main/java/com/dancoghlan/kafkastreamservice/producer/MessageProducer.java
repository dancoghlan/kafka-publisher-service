package com.dancoghlan.kafkastreamservice.producer;

public interface MessageProducer {

    void sendMessage(String msg);
}
