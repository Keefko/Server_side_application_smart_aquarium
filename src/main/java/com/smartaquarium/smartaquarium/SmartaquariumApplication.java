package com.smartaquarium.smartaquarium;

import com.smartaquarium.smartaquarium.service.MqttBrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication

public class SmartaquariumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartaquariumApplication.class, args);

	}
}
