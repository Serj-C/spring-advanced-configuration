package main.factory_beans;

import com.example.factory_beans.MessageDigestFactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class FactoryBeansDirectAccess {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/factory_beans/app-context.xml");
        ctx.refresh();
        ctx.getBean("shaDigest", MessageDigest.class);

        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");

        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("Hello World!".getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ctx.close();
    }
}
