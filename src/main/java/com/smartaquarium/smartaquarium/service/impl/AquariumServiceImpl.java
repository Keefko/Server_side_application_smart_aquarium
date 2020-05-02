package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.repository.AquariumRepository;
import com.smartaquarium.smartaquarium.service.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AquariumServiceImpl implements AquariumService {

    private AquariumRepository aquariumRepository;

    @Autowired
    public AquariumServiceImpl(AquariumRepository aquariumRepository) {
        this.aquariumRepository = aquariumRepository;
    }

    @Override
    public List<Aquarium> getAquariums() {
        return aquariumRepository.findAll();
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
        }else {
            throw new RuntimeException("Nenašlo sa aqurium s id" + id);
        }
        return aquarium;
    }

    @Override
    public Integer add(Aquarium aquarium) {
        return aquariumRepository.save(aquarium).getId();
    }

    @Override
    public void deleteById(Integer id) {
        aquariumRepository.deleteById(id);
    }

    public void deleteAllByUserId(Integer id){
        aquariumRepository.DeleteAllByUserId(id);
    }

}
