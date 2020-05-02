package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.repository.ComponentRepository;
import com.smartaquarium.smartaquarium.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentServiceImpl implements ComponentService {

    private ComponentRepository componentRepository;

    @Autowired
    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public List<Component> getAllComponentsByAquariumId(Integer aquariumId) {
        return componentRepository.getAllComponentsByAquariumId(aquariumId);
    }

    @Override
    public Component get(Integer id) {
        Optional<Component> optional = componentRepository.findById(id);
        Component component = null;
        if(optional.isPresent()){
            component = optional.get();
        } else{
            throw new RuntimeException("Ovládač s id" + id + "neexistuje");
        }
        return component;
    }

    @Override
    public void add(Component component) {
        componentRepository.save(component);
    }

    @Override
    public void deleteById(Integer id) {
        componentRepository.deleteById(id);
    }
}
