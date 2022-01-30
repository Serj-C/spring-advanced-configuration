package main.accessing_resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class ResourcesDemo {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", ".txt");
        file.deleteOnExit();

        Resource res1 = context.getResource("file:/" + file.getPath());
        displayInfo(res1);

        Resource res2 = context.getResource("classpath:test.txt");
        displayInfo(res2);

        Resource res3 = context.getResource("http://www.google.com");
        displayInfo(res3);
    }

    private static void displayInfo(Resource resource) throws IOException {
        System.out.println(resource.getClass());
        System.out.println(resource.getURL().getContent());
        System.out.println();
    }
}
