package main.message_source_internationalization;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/message_source_internationalization/app-context.xml");
        context.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(context.getMessage("msg", new Object[]{}, english));
        System.out.println(context.getMessage("nameMsg", new Object[]{"John", "Mayer"}, english));

        System.out.println(context.getMessage("msg", new Object[]{}, german));
        System.out.println(context.getMessage("nameMsg", new Object[]{"John", "Mayer"}, german));

        context.close();
    }
}
