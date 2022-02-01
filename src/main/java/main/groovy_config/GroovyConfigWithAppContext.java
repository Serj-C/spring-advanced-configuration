package main.groovy_config;

import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyConfigWithAppContext {
    public static void main(String[] args) {
        // You can also run GroovyConfig.groovy directly
        new GenericGroovyApplicationContext(
                "classpath:spring/groovy_config/GroovyConfig.groovy");
    }
}
