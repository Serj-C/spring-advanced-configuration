package com.example.spring_aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
    /** @Implements {@link ApplicationContextAware#setApplicationContext(ApplicationContext)} */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof GenericXmlApplicationContext) {
            ((GenericXmlApplicationContext) applicationContext).registerShutdownHook();
        }
    }
}
