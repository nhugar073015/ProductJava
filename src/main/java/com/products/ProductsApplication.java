package com.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@ComponentScan("com.products")
@SpringBootApplication
@EnableSwagger2
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
		System.out.println("Product Application is Running now!...");
		System.out.println("Just for testing!...")
	}

}
