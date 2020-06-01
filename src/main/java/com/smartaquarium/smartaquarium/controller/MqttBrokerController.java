package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.MqttBroker;
import com.smartaquarium.smartaquarium.service.MqttBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("broker")
public class MqttBrokerController {

    private MqttBrokerService mqttBrokerService;

    @Autowired
    public MqttBrokerController(MqttBrokerService mqttBrokerService) {
        this.mqttBrokerService = mqttBrokerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getBrokerByAquariumId(@PathVariable Integer id){
        MqttBroker mqttBroker = mqttBrokerService.getBrokerDataByAquariumId(id);
        if(mqttBroker != null){
            return new ResponseEntity<>(mqttBroker,HttpStatus.OK);
        }
        return new ResponseEntity<>("Nastavenie brokera pre dane akvárium neexistuje", HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity update(MqttBroker mqttBroker){
        if(mqttBrokerService.get(mqttBroker.getId()) != null){
            mqttBrokerService.add(mqttBroker);
            return new ResponseEntity<>(mqttBroker,HttpStatus.OK);
        }
        return new ResponseEntity<>("Nastavenie brokera pre dane akvárium neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        MqttBroker mqttBroker = mqttBrokerService.get(id);
        if(mqttBroker != null){
            mqttBrokerService.deleteById(id);
            return new ResponseEntity<>("Nastavenia brokera s id " + id + " bolo vymazane",HttpStatus.OK);
        }
        return new ResponseEntity<>("Nastavenie brokera pre dane akvárium neexistuje", HttpStatus.NOT_FOUND);
    }
}
