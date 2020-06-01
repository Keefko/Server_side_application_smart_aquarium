package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.MqttBroker;
import com.smartaquarium.smartaquarium.repository.MqttBrokerRepository;
import com.smartaquarium.smartaquarium.service.MqttBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MqttBrokerServiceImpl implements MqttBrokerService {

    private MqttBrokerRepository mqttBrokerRepository;

    @Autowired
    public MqttBrokerServiceImpl(MqttBrokerRepository mqttBrokerRepository) {
        this.mqttBrokerRepository = mqttBrokerRepository;
    }

    @Override
    public MqttBroker getBrokerDataByAquariumId(Integer aquariumId) {
        return mqttBrokerRepository.getBrokerDataByAquariumId(aquariumId);
    }

    @Override
    public MqttBroker get(Integer id) {
        Optional<MqttBroker> optional = mqttBrokerRepository.findById(id);
        MqttBroker mqttBroker = null;
        if(optional.isPresent()){
            mqttBroker = optional.get();
        }
        return mqttBroker;
    }

    @Override
    public MqttBroker add(MqttBroker mqttBroker) {
        return mqttBrokerRepository.save(mqttBroker);
    }

    @Override
    public void deleteById(Integer id) {
        mqttBrokerRepository.deleteById(id);
    }
}
