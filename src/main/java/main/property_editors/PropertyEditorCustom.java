package main.property_editors;

import com.example.property_editors.FullName;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorCustom {
    private FullName fullName;

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/property_editors/app-context-2.xml");
        ctx.refresh();

        PropertyEditorCustom bean = (PropertyEditorCustom) ctx.getBean("exampleBean");
        System.out.println(bean.getFullName());

        ctx.close();
    }
}
