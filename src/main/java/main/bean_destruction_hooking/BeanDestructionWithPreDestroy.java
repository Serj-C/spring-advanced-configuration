package main.bean_destruction_hooking;

import com.example.spring_aware.ShutdownHookBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class BeanDestructionWithPreDestroy {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of "
                    + BeanDestructionWithPreDestroy.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }

        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/bean_destruction_with_pre_destroy/app-context.xml");
        ctx.refresh();

        ctx.getBean("destructiveBean", BeanDestructionWithPreDestroy.class);

        // A bean of type ShutdownHookBean is created to call registerShutdownHook() method.
        // See beans created in spring/bean_destruction_with_pre_destroy/app-context.xml
    }
}
