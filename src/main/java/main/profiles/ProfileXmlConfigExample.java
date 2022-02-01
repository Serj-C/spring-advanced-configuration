package main.profiles;

import com.example.profiles.Food;
import com.example.profiles.FoodProviderService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();

        // Equivalent to -Dspring.profiles.active="high-school"
        applicationContext.getEnvironment().setActiveProfiles("high-school");

        applicationContext.load("classpath:spring/profiles/*-config.xml");
        applicationContext.refresh();

        FoodProviderService foodProviderService =
                applicationContext.getBean("foodProviderService", FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();

        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }

        applicationContext.close();
    }
}
