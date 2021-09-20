package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class LmsystemApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder application) {
		return application.sources(LmsystemApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(LmsystemApplication.class, args);
	}

}

/*package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsystemApplication.class, args);
	}

}
*/