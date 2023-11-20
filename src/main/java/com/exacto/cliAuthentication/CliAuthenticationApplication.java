package com.exacto.cliAuthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages = {"com.exacto.cliAuthentication.monitor", "com.exacto.cliAuthentication"})
@SpringBootApplication 
//@ComponentScan(basePackages = "com.exacto.cliAuthentication")
public class CliAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliAuthenticationApplication.class, args);
	}
}