package com.codedecode.microservice.EureakServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureakServerApplication {
// this project are create with help of CODEDECODE YOUTUBE CHANNE & This service are connect with CitizenService
	public static void main(String[] args) {
		SpringApplication.run(EureakServerApplication.class, args);
		System.out.println("EureakServer Started....!");
	}

}
