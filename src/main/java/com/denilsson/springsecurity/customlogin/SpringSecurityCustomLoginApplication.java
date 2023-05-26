package com.denilsson.springsecurity.customlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpringSecurityCustomLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCustomLoginApplication.class, args);
	}

}
