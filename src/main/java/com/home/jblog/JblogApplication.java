package com.home.jblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan
public class JblogApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(JblogApplication.class, args);
	}
	
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JblogApplication.class);
	}

}
