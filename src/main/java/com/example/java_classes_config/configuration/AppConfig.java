package com.example.java_classes_config.configuration;

import com.example.java_classes_config.MessageProvider;
import com.example.java_classes_config.MessageRenderer;
import com.example.java_classes_config.impl.ConfigurableMessageProvider;
import com.example.java_classes_config.impl.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:message.properties")
// For XML, <context:property-placeholder> serves the same purpose.
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(environment.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        StandardOutMessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());

        return messageRenderer;
    }
}
