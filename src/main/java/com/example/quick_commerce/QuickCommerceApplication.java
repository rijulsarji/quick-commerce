package com.example.quick_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickCommerceApplication.class, args);
		// <application_name>.run creates a container. Objects are created inside the JVM. Inside the JVM exists an IoC container, where it stores the objects.
		//	The	type of the container (JVM, IoC containers) that runs is extended from ApplicationContext
    }

}
