package main.java_classes_configuration;

import com.example.java_classes_configuration.MessageRenderer;
import com.example.java_classes_configuration.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleOne {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
