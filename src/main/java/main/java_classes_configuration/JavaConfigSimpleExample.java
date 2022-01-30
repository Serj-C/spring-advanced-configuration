package main.java_classes_configuration;

import com.example.java_classes_configuration.ConfigurableMessageProvider;
import com.example.java_classes_configuration.MessageProvider;
import com.example.java_classes_configuration.MessageRenderer;
import com.example.java_classes_configuration.StandardOutMessageRenderer;
import com.example.java_classes_configuration.configuration.AppConfigOne;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JavaConfigSimpleExample {
    @Configuration
    static class AppConfig {
        @Bean
        MessageProvider messageProvider() {
            return new ConfigurableMessageProvider();
        }

        @Bean
        MessageRenderer messageRenderer() {
            StandardOutMessageRenderer messageRenderer = new StandardOutMessageRenderer();
            messageRenderer.setMessageProvider(messageProvider());

            return messageRenderer;
        }
    }

    public static void main(String[] args) {
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigOne.class);

        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
