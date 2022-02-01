package com.example.spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldWeb {

    @RequestMapping
    public String greeting() {
        return "Hello World!";
    }
}
