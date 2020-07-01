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

    @Autowired
    AquariumRepository aquariumRepository;

    @Scheduled(fixedRate = 60*60*1000)
    public void reportCurrentTime() throws MqttException {
        List<Aquarium> aquariums = aquariumRepository.findAll();
        for(Aquarium aquarium : aquariums){
            mqttService.getData(aquarium.getId(), "senzors");
        }
    }
}