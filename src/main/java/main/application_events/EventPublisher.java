package main.application_events;

import com.example.application_events.MessageEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventPublisher implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Setting ApplicationContext context field");
        this.context = applicationContext;
    }

    public void publish(String message) {
        context.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/application_events/app-context.xml");

        EventPublisher eventPublisher = (EventPublisher) context.getBean("publisher");
        eventPublisher.publish("I send an SOS to the world...");
        eventPublisher.publish("... I hope that someone gets my...");
        eventPublisher.publish("... Message in a bottle");
    }
}
