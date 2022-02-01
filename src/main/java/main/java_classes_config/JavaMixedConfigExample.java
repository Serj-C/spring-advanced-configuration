package main.java_classes_config;

import com.example.java_classes_config.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaMixedConfigExample {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/java_classes_config/app-context-3.xml");

        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);

        messageRenderer.render();
    }
}
