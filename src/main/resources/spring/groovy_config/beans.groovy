package spring.groovy_config

import com.example.groovy_config.Singer

beans {
    singer(Singer, name: 'John Mayer', age: 39)
}
