package com.ecom.backendecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@Configuration
public class BackendecommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendecommerceApplication.class, args);
	}

}
