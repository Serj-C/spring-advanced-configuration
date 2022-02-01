package main.java_classes_config;

import com.example.java_classes_config.MessageRenderer;
import com.example.java_classes_config.configuration.AppConfigFive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleTwoThreeAndFive {
    public static void main(String[] args) {
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigTwo.class);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigThree.class);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigFive.class);

        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);

        messageRenderer.render();
    }
}
