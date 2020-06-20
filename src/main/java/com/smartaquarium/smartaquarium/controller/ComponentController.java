package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.service.ComponentService;
import com.smartaquarium.smartaquarium.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("components")
public class ComponentController {

    private ComponentService componentService;
    private MqttService mqttService;

    @Autowired
    public ComponentController(ComponentService componentService, MqttService mqttService) {
        this.componentService = componentService;
        this.mqttService = mqttService;
    }

    @GetMapping("/aquarium/{id}")
    public List<Component> getAllComponentsByAquariumId(@PathVariable Integer id){
        return componentService.getAllComponentsByAquariumId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        Component component = componentService.get(id);
        if(component != null){
            return new ResponseEntity<>(component, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ovládací prvok s id" + id + "neexistuje", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity  add(@RequestBody Component component){
        Component component1 = componentService.get(component.getId());
        if(component1 == null) {
            componentService.add(component);
            return new ResponseEntity(component, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ovládací prvok už existuje", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity  updateComponent(@RequestBody Component component) throws MqttException {
        Component component1 = componentService.get(component.getId());
        if(component1 != null){
            componentService.add(component);
            mqttService.sendData(component);
            return new ResponseEntity<>(component, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ovládací prvok neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        Component component = componentService.get(id);
        if(component != null) {
            componentService.deleteById(id);
            return new ResponseEntity<>("ovládaci prvok bol zmazaný", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ovládací prvok neexistuje", HttpStatus.NOT_FOUND);
    }

}
