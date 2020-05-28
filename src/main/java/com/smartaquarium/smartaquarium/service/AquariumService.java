package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.Aquarium;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AquariumService {

    List<Aquarium> getAllUsersAquariums(Integer userId);
    Aquarium get(Integer id);
    Integer add(Aquarium aquarium);
    Aquarium update(Aquarium aquarium);
    void deleteById(Integer id);

}
