package main.spring_boot;

import com.example.spring_boot.HelloWorldWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication(scanBasePackageClasses = HelloWorldWeb.class)
public class SpringBootWebDemo {
    private static Logger logger =
            LoggerFactory.getLogger(SpringBootWebDemo.class);

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(SpringBootWebDemo.class);

        assert (applicationContext != null);

        logger.info("Application started");

        System.in.read();

        applicationContext.close();
    }
}
