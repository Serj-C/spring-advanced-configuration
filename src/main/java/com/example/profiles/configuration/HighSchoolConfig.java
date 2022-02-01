package com.example.profiles.configuration;

import com.example.profiles.FoodProviderService;
import com.example.profiles.high_school.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("high-school")
public class HighSchoolConfig {

    @Bean
    public FoodProviderService foodProviderService() {
        return new FoodProviderServiceImpl();
    }
}
