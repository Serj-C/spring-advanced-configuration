package com.example.java_classes_configuration.configuration;

import com.example.java_classes_configuration.ConfigurableMessageProvider;
import com.example.java_classes_configuration.MessageProvider;
import com.example.java_classes_configuration.MessageRenderer;
import com.example.java_classes_configuration.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    MessageProvider messageProvider() {
        return new ConfigurableMessageProvider();
    }

    @Bean
    MessageRenderer messageRenderer() {
        StandardOutMessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());

        return messageRenderer;
    }
}
