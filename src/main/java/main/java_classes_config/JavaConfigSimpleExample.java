package main.java_classes_config;

import com.example.java_classes_config.MessageProvider;
import com.example.java_classes_config.MessageRenderer;
import com.example.java_classes_config.impl.ConfigurableMessageProvider;
import com.example.java_classes_config.impl.StandardOutMessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JavaConfigSimpleExample {

    @Configuration
    static class AppConfigOne {

        @Bean
        public MessageProvider messageProvider() {
            return new ConfigurableMessageProvider();
        }

        @Bean
        public MessageRenderer messageRenderer() {
            StandardOutMessageRenderer messageRenderer = new StandardOutMessageRenderer();
            messageRenderer.setMessageProvider(messageProvider());

            return messageRenderer;
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigOne.class);

        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);

        messageRenderer.render();
    }
}
