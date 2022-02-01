package com.example.java_classes_config.configuration;

import com.example.java_classes_config.MessageProvider;
import com.example.java_classes_config.MessageRenderer;
import com.example.java_classes_config.impl.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfigFour.class)
public class AppConfigThree {

    @Autowired
    MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);

        return renderer;
    }
}
