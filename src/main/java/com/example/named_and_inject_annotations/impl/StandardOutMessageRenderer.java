package com.example.named_and_inject_annotations.impl;

import com.example.named_and_inject_annotations.MessageProvider;
import com.example.named_and_inject_annotations.MessageRenderer;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("messageRenderer")
@Singleton
// In the JSR-330 standard, a bean’s default scope is non-singleton,
// which is like Spring's prototype scope.
// @Singleton has no effect here as by default in Spring scope is already Singleton.
public class StandardOutMessageRenderer implements MessageRenderer {

    @Inject
    @Named("messageProvider")
    private MessageProvider messageProvider = null;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of the class: "
                    + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
