package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.entity.Connection;
import com.smartaquarium.smartaquarium.service.ComponentService;
import com.smartaquarium.smartaquarium.service.ConnectionService;
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
    private ConnectionService connectionService;


    @Autowired
    public ComponentController(ComponentService componentService, MqttService mqttService, ConnectionService connectionService) {
        this.componentService = componentService;
        this.mqttService = mqttService;
        this.connectionService = connectionService;
    }

    @GetMapping("/aquarium/{id}")
    public List<Component> getAllComponentsByAquariumId(@PathVariable Integer id){
        return componentService.getAllComponentsByAquariumId(id);
    }

    @GetMapping("/aquarium/{id}/{name}")
    public ResponseEntity get(@PathVariable Integer id, @PathVariable String name){
        Component component = componentService.getByNameandId(id,name);
        if(component != null){
            return new ResponseEntity<>(component, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ovládací prvok s id" + id + "neexistuje", HttpStatus.NOT_FOUND);
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
            Connection connection = connectionService.getByAquariumId(component.getAquariumId());
            if("light".equals(component.getName())){
                connection.setLight(true);
            }

            if("thermometer".equals(component.getName())){
                connection.setThermometer(true);
            }

            if("feeding".equals(component.getName())){
                connection.setFeeding(true);
            }
            connectionService.add(connection);
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
