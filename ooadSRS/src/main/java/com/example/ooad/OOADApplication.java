package com.example.ooad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication(scanBasePackages = {"com.example.ooad.controller", "com.example.ooad.service",
    "com.example.ooad.domin","com.example.ooad.action","com.example.ooad.specification"})
@MapperScan("com.example.ooad.dao")
@EnableConfigurationProperties
public class OOADApplication {

    public static void main(String[] args) {
        SpringApplication.run(OOADApplication.class, args);
    }
}
