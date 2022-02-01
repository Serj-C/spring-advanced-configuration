package com.example.java_classes_config.impl;

import com.example.java_classes_config.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default message";

    public ConfigurableMessageProvider() {
    }

    @Autowired // Specifies that this constructor will be called for MessageProvider provider from AppConfigTwo class.
    public ConfigurableMessageProvider(@Value("Love on the weekend") String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
