package com.springboot.SpringbootDockerk8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.springboot.SpringbootDockerk8")
// @ComponentScan(basePackages = "com.springboot.SpringbootDockerk8.job")
public class SpringbootDockerk8Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerk8Application.class, args);
	}

}
