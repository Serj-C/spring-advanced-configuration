package main.groovy_config;

import com.example.groovy_config.Singer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyConfigDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new GenericGroovyApplicationContext(
                "classpath:spring/groovy_config/beans.groovy");

        Singer singer = applicationContext.getBean("singer", Singer.class);

        System.out.println(singer);
    }
}
