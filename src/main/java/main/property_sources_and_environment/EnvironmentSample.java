package main.property_sources_and_environment;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.refresh();

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        Map<String, Object> appMap = new HashMap<>();
        appMap.put("user.home", "application_home");

        propertySources.addFirst(new MapPropertySource("appMapName", appMap));

        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));

        System.out.println("user.home: " + environment.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + environment.getProperty("JAVA_HOME"));

        applicationContext.close();
    }
}
