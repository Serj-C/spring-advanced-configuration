package main.profiles;

import com.example.profiles.Food;
import com.example.profiles.FoodProviderService;
import com.example.profiles.configuration.HighSchoolConfig;
import com.example.profiles.configuration.KindergartenConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ProfileJavaConfigExample {
    public static void main(String[] args) {
        // Executed with -Dspring.profiles.active="high-school" JVM argument

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(
                        HighSchoolConfig.class,
                        KindergartenConfig.class);

        FoodProviderService foodProviderService =
                applicationContext.getBean("foodProviderService", FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();

        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }

        applicationContext.close();
    }
}
