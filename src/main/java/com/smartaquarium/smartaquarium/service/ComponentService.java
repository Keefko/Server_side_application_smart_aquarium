package com.smartaquarium.smartaquarium.service;


import com.smartaquarium.smartaquarium.entity.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComponentService {

    List<Component> getAllComponentsByAquariumId(Integer aquariumId);
    Component get(Integer id);
    void add(Component component);
    void deleteById(Integer id);

}
