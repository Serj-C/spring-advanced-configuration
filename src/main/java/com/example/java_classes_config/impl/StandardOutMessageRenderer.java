package com.example.java_classes_config.impl;

import com.example.java_classes_config.MessageProvider;
import com.example.java_classes_config.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public StandardOutMessageRenderer() {
        System.out.println(" --> StandardOutMessageRenderer: Constructor called");
    }

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class: "
                    + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        System.out.println(" --> StandardOutMessageRenderer: Setting the provider");
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
