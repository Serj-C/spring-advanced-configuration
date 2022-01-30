package com.example.application_events;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent msgEvent = event;
        System.out.println("Received: " + msgEvent.getMessage());
    }
}
