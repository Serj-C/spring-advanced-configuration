package main.factory_beans;

import com.example.factory_beans.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FactoryBeansDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/factory_beans/app-context.xml");
        ctx.refresh();

        MessageDigester messageDigester = ctx.getBean("digester", MessageDigester.class);
        messageDigester.digest("Hello World!");

        ctx.close();
    }
}
