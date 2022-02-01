package com.example.java_classes_config;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
