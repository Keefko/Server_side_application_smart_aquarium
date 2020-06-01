package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.MqttBroker;
import org.springframework.stereotype.Service;

@Service
public interface MqttBrokerService {
    MqttBroker getBrokerDataByAquariumId(Integer aquariumId);
    MqttBroker get(Integer id);
    MqttBroker add(MqttBroker mqttBroker);
    void deleteById(Integer id);
}
