package spring.groovy_config

import com.example.groovy_config.Singer
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def applicationContext = new GenericApplicationContext()
def reader = new GroovyBeanDefinitionReader(applicationContext);

reader.beans {
    singer(Singer, name: 'John Mayer', age: 39)
}

applicationContext.refresh()

def singer = applicationContext.getBean("singer")
println singer;
