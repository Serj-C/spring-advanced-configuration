package com.example.java_classes_config.configuration;

import com.example.java_classes_config.MessageProvider;
import com.example.java_classes_config.MessageRenderer;
import com.example.java_classes_config.impl.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.java_classes_config.impl"})
// It's the same as the <context:component-scan> tag in the XML configuration.
public class AppConfigTwo {

    @Autowired
    MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        StandardOutMessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);

        return renderer;
    }
}
