package main.java_classes_configuration;

import com.example.java_classes_configuration.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigXMLExample {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/java_classes_configuration/app-context.xml");

        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
