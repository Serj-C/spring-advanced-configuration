package main.spring_boot;

import com.example.spring_boot.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication(scanBasePackageClasses = HelloWorld.class)
public class SpringBootDemo {
    private static Logger logger = LoggerFactory.getLogger(SpringBootDemo.class);

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(SpringBootDemo.class, args);

        assert (applicationContext != null);

        logger.info("The beans you are looking for:");

        // Listing all bean definition names
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(logger::info);

        HelloWorld bean = applicationContext.getBean(HelloWorld.class);
        bean.greeting();

        System.in.read();

        applicationContext.close();
    }
}
