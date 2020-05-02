package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("components")
public class ComponentController {

    private ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping("/aquarium/{id}")
    public List<Component> getAllComponentsByAquariumId(@PathVariable Integer id){
        return componentService.getAllComponentsByAquariumId(id);
    }

    @GetMapping("/{id}")
    public Component get(@PathVariable Integer id){
        Component component = componentService.get(id);
        if(component == null){
            throw new RuntimeException("Ovladací prvok s id" +id+ "neexistuje");
        }
        return component;
    }

    @PostMapping("/add")
    public void add(@RequestBody Component component){
        componentService.add(component);
    }

    @PutMapping
    public Component updateComponent(@RequestBody Component component){
        componentService.add(component);
        return component;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        componentService.deleteById(id);
    }

}
