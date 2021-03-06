package main.bean_destruction_hooking;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class BeanDestructionDestroyMethod implements InitializingBean {
    private File file;
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of "
                    + BeanDestructionDestroyMethod.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

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
        ctx.load("classpath:spring/bean_destruction_destoy_method/app-context.xml");
        ctx.refresh();

        BeanDestructionDestroyMethod bean = (BeanDestructionDestroyMethod) ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.close();
        System.out.println("Called destroy()");
    }
}
