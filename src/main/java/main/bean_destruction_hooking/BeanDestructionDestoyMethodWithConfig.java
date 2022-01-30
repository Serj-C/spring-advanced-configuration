package main.bean_destruction_hooking;

import com.example.bean_destruction_with_config.MyFile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

public class BeanDestructionDestoyMethodWithConfig {

    @Configuration
    static class BeanDestructionConfig {
        @Lazy
        @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destroy")
        MyFile destructiveBean() {
            MyFile destructiveBean = new MyFile();
            destructiveBean.setFilePath(System.getProperty("java.io.tmpdir")
                    + System.getProperty("file.separator") + "test.txt");
            return destructiveBean;
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanDestructionConfig.class);

        ctx.getBean("destructiveBean");

        ctx.registerShutdownHook();
    }
}
