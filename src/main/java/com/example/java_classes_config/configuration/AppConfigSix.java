package com.example.java_classes_config.configuration;

import com.example.java_classes_config.MessageProvider;
import com.example.java_classes_config.impl.ConfigurableMessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigSix {

    @Bean
    public MessageProvider provider() {
        return new ConfigurableMessageProvider("Spring mixed configuration example");
    }
}
