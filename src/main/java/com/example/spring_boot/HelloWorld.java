package com.example.spring_boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public void greeting() {
        logger.info("Hello World!");
    }
}
