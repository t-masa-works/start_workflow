package com.gogoing.workflow;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication( exclude= SecurityAutoConfiguration.class)
@MapperScan("com.activiti6.mapper")
@EnableScheduling
public class WorkflowApplication {

	public static void main_(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
	}

}
