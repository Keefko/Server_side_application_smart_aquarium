package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.entity.MqttBroker;
import com.smartaquarium.smartaquarium.repository.AquariumRepository;
import com.smartaquarium.smartaquarium.service.AquariumService;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
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

    @Autowired
    public AquariumServiceImpl(AquariumRepository aquariumRepository, AquariumSettingsService aquariumSettingsService, MqttBrokerService mqttBrokerService, DeleteRequest deleteRequest) {
        this.aquariumRepository = aquariumRepository;
        this.aquariumSettingsService = aquariumSettingsService;
        this.mqttBrokerService = mqttBrokerService;
        this.deleteRequest = deleteRequest;
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
        MqttBroker mqttBroker = new MqttBroker(aquarium.getId(),"none", "none", "none");
        mqttBrokerService.add(mqttBroker);
        return aquarium;
    }

    public Aquarium update(Aquarium aquarium){
        AquariumSettings aquariumSettings = aquariumSettingsService.getSettingByAquariumId(aquarium.getId());
        if(!aquariumSettings.getName().equals(aquarium.getName())){
            aquariumSettings.setName(aquarium.getName());
            aquariumSettingsService.add(aquariumSettings);
        }
        return aquariumRepository.save(aquarium);
    }

    @Override
    public void deleteById(Integer id) {
        deleteRequest.deleteAquariumConexions(id);
        aquariumRepository.deleteById(id);
    }
}

