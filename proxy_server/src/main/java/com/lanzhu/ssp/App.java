package com.lanzhu.ssp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.lanzhu.ssp"})
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class);
    }
}
