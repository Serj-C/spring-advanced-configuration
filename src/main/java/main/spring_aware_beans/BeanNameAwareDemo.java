package main.spring_aware_beans;

import com.example.spring_aware.NamedSinger;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNameAwareDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/bean_name_aware/app-context.xml");
        ctx.refresh();

        NamedSinger bean = (NamedSinger) ctx.getBean("johnMayer");
        bean.sing();

        ctx.close();
    }
}
