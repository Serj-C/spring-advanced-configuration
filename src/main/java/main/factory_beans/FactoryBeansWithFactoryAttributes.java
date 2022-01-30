package main.factory_beans;

import com.example.factory_beans.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FactoryBeansWithFactoryAttributes {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/factory_beans/app-context-factory-attributes.xml");
        ctx.refresh();

        MessageDigester messageDigester = ctx.getBean("digester", MessageDigester.class);
        messageDigester.digest("Hello World!");

        ctx.close();
    }
}
