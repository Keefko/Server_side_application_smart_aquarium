package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.repository.AquariumRepository;
import com.smartaquarium.smartaquarium.service.AquariumService;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
import com.smartaquarium.smartaquarium.service.handling.DeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AquariumServiceImpl implements AquariumService {

    private AquariumRepository aquariumRepository;
    private AquariumSettingsService aquariumSettingsService;

    @Autowired
    public AquariumServiceImpl(AquariumRepository aquariumRepository, AquariumSettingsService aquariumSettingsService) {
        this.aquariumRepository = aquariumRepository;
        this.aquariumSettingsService = aquariumSettingsService;
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
    public Integer add(Aquarium aquarium) {
        List<Aquarium> aquariums = aquariumRepository.findAllByUserId(aquarium.getUserId());
        aquarium.setName("Aquarium " + aquariums.size());
        AquariumSettings aquariumSettings = new AquariumSettings(7,200,20.0, aquarium.getId(), aquarium.getName());
        aquariumSettingsService.add(aquariumSettings);
        return aquariumRepository.save(aquarium).getId();
    }

    @Override
    public void deleteById(Integer id) {
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.deleteAquariumConexions(id);
        aquariumRepository.deleteById(id);
    }



}

