package com.aron.t1parte2.mcvc_clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class McvcClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(McvcClientsApplication.class, args);
	}

}
