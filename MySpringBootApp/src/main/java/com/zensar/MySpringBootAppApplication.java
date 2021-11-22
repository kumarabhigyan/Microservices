package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2

public class MySpringBootAppApplication {

	public static void main(String[] args) {
		System.out.println("Spring Boot App started...");
		SpringApplication.run(MySpringBootAppApplication.class, args);
	}

}
