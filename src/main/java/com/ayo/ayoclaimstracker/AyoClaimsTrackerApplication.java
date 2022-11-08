package com.ayo.ayoclaimstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"src/main/java/com/ayo/ayoclaimstracker/controllers"})
public class AyoClaimsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyoClaimsTrackerApplication.class, args);
	}

}
