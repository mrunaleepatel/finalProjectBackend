package com.ecom.backendecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@Configuration
@PropertySource("classpath:application.properties")
public class BackendecommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendecommerceApplication.class, args);
	}

}
