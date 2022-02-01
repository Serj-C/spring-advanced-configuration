package main.property_sources_and_environment;

import com.example.property_sources_and_environment.AppProperty;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyPlaceholderDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load(
                "classpath:spring/property_sources_and_environment/app-context.xml");
        applicationContext.refresh();

        AppProperty appProperty = applicationContext.getBean("appProperty", AppProperty.class);

        System.out.println("application.home: " + appProperty.getApplicationHome());
        System.out.println("user.home: " + appProperty.getUserHome());

        applicationContext.close();
    }
}
