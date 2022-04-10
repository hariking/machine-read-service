package com.myapp.machine.read.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myapp.machine.read.service.websocket.WSClient;

@SpringBootApplication
public class MachineReadServiceStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(MachineReadServiceStarter.class, args);
		WSClient.connectToServer();
	}
	
}