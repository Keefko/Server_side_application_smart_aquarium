package com.smartaquarium.smartaquarium;

import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class SmartaquariumApplication {


	public static void main(String[] args) throws MqttException {
		SpringApplication.run(SmartaquariumApplication.class, args);
		MqttService mqttService = new MqttService();
		mqttService.getData();
		Component component = new Component(90425,"filtrácia","Jozef",false, Timestamp.from(Instant.now()),false,150);
		mqttService.sendData(component);
	}
}
