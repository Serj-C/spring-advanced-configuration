package com.example.java_classes_config.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.java_classes_config.impl"})
public class AppConfigFour {
}
