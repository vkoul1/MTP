package com.perficient.mtp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = "com.perficient.mtp.*")
@EnableAspectJAutoProxy
public class MTP_Appliction {

	public static void main(String[] args) {
		SpringApplication.run(MTP_Appliction.class, args);
	}

}