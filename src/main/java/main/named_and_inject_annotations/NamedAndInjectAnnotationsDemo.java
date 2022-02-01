package main.named_and_inject_annotations;

import com.example.named_and_inject_annotations.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NamedAndInjectAnnotationsDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load(
                "classpath:spring/named_and_inject_annotations/app-context.xml");
        applicationContext.refresh();

        MessageRenderer renderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();

        applicationContext.close();
    }
}
