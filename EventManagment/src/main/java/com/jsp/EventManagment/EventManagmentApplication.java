package com.jsp.EventManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jsp.EventManagment.CONTROLLER"})
public class EventManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagmentApplication.class, args);
	}

}
