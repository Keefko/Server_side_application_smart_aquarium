package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.entity.Connection;
import com.smartaquarium.smartaquarium.entity.MqttBroker;
import com.smartaquarium.smartaquarium.repository.AquariumRepository;
import com.smartaquarium.smartaquarium.repository.MqttBrokerRepository;
import com.smartaquarium.smartaquarium.service.AquariumService;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
import com.smartaquarium.smartaquarium.service.ConnectionService;
import com.smartaquarium.smartaquarium.service.MqttBrokerService;
import com.smartaquarium.smartaquarium.service.handling.DeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AquariumServiceImpl implements AquariumService {

    private AquariumRepository aquariumRepository;
    private AquariumSettingsService aquariumSettingsService;
    private MqttBrokerService mqttBrokerService;
    private DeleteRequest deleteRequest;
    private ConnectionService connectionService;
    private MqttBrokerRepository mqttBrokerRepository;

    @Autowired
    public AquariumServiceImpl(AquariumRepository aquariumRepository, AquariumSettingsService aquariumSettingsService, MqttBrokerService mqttBrokerService, DeleteRequest deleteRequest, ConnectionService connectionService, MqttBrokerRepository mqttBrokerRepository) {
        this.aquariumRepository = aquariumRepository;
        this.aquariumSettingsService = aquariumSettingsService;
        this.mqttBrokerService = mqttBrokerService;
        this.deleteRequest = deleteRequest;
        this.connectionService = connectionService;
        this.mqttBrokerRepository = mqttBrokerRepository;
    }


    public List<Aquarium> getAllUsersAquariums(Integer userId){
        return aquariumRepository.findAllByUserId(userId);
    }

    @Override
    public Aquarium get(Integer id) {
        Optional<Aquarium> optional = aquariumRepository.findById(id);
        Aquarium aquarium = null;
        if(optional.isPresent()){
            aquarium = optional.get();
        }
        return aquarium;
    }

    @Override
    public Aquarium add(Aquarium aquarium) {
        List<Aquarium> aquariums = aquariumRepository.findAllByUserId(aquarium.getUserId());
        aquarium.setName("Aquarium " + aquariums.size());
        aquariumRepository.save(aquarium);
        AquariumSettings aquariumSettings = new AquariumSettings(7,200,20.0, aquarium.getId(), aquarium.getName());
        aquariumSettingsService.add(aquariumSettings);
        Connection connection = new Connection(aquarium.getId(),false,false,false,false,false,false);
        connectionService.add(connection);
        MqttBroker mqttBroker = new MqttBroker(aquarium.getId(),"none", "none", "none");
        mqttBrokerService.add(mqttBroker);
        return aquarium;
    }

    @Override
    public void deleteById(Integer id) {
        deleteRequest.deleteAquariumConexions(id);
        aquariumRepository.deleteById(id);
    }

}

