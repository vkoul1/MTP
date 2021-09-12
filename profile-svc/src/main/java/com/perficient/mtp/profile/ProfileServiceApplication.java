package com.perficient.mtp.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = "com.perficient.mtp")
@EnableAspectJAutoProxy
public class ProfileServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}
}