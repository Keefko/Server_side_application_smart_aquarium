package com.smartaquarium.smartaquarium.service.handling;

import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.repository.AquariumRepository;
import com.smartaquarium.smartaquarium.service.MqttBrokerService;
import com.smartaquarium.smartaquarium.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    MqttService mqttService;


    @Scheduled(fixedRate = 4000)
    public void reportCurrentTime() throws MqttException {
        mqttService.getData(15425, "BaJoP1/4/WQLTP1/1");
    }
}