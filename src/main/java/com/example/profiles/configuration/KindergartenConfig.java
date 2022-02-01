package com.example.profiles.configuration;

import com.example.profiles.FoodProviderService;
import com.example.profiles.kindergarten.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("kindergarten")
public class KindergartenConfig {

    @Bean
    public FoodProviderService foodProviderService() {
        return new FoodProviderServiceImpl();
    }
}
