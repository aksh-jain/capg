package com.capgemini.discover.fingerpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.capgemini.discover.fingerpay")
public class FingerPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FingerPayApplication.class, args);
	}
}
