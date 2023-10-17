package com.ecom.backendecommerce;

import io.github.cdimascio.dotenv.Dotenv;
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

	// Load environment variables from .env file
	Dotenv dotenv = Dotenv.configure().load();

	// Access environment variables
	String dbUrl = dotenv.get("DB_URL");
	String dbUsername = dotenv.get("DB_USERNAME");
	String dbPassword = dotenv.get("DB_PASSWORD");
	public static void main(String[] args) {
		SpringApplication.run(BackendecommerceApplication.class, args);
	}

}
