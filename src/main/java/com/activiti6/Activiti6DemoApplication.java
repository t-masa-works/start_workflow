package com.activiti6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("com.activiti6.mapper")
@EnableScheduling
@ComponentScan(basePackages = { "com.activiti6.controller","com.activiti6.service",
"io.swagger", "io.swagger.api", "io.swagger.configuration" })


public class Activiti6DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(Activiti6DemoApplication.class, args);
    }
}
