package com.bachelor.smartaquarium.service.Impl;

import com.bachelor.smartaquarium.Repository.AquariumRepository;
import com.bachelor.smartaquarium.entity.Aquarium;
import com.bachelor.smartaquarium.service.api.AquariumService;
import com.bachelor.smartaquarium.service.api.Request.UpdateAquariumRequest;

import java.util.List;
import java.util.Optional;

public class AquariumServiceImpl implements AquariumService {

    private final AquariumRepository aquariumRepository;

    public AquariumServiceImpl(AquariumRepository aquariumRepository) {
        this.aquariumRepository = aquariumRepository;
    }

    @Override
    public List<Aquarium> getAquariums(){
        return aquariumRepository.findAll();
    }

    @Override
    public Aquarium get(int id){
        Optional<Aquarium> aquarium = aquariumRepository.findById(id);

        if(aquarium.isPresent()){
            return aquarium.get();
        } else{
            return null;
        }
    }

    @Override
    public Aquarium add(Aquarium aquarium) {
        return aquariumRepository.save(aquarium);
    }

    @Override
    public void delete(int id) {
        aquariumRepository.deleteById(id);
    }

    @Override
    public Aquarium update(int id, UpdateAquariumRequest request) {
        Optional<Aquarium> aquarium = aquariumRepository.findById(id);

        if(aquarium.isPresent()){
            Aquarium newAquarium = aquarium.get();
            newAquarium.setType(request.getType());
            newAquarium.setStatus(request.getStatus());
            newAquarium.setName(request.getName());
            return add(newAquarium);
        } else {
            return add(aquarium.get());
        }
    }
}
