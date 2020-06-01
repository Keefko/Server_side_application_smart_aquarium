package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.MqttControllers.MqttCall;
import com.smartaquarium.smartaquarium.MqttControllers.MqttComponentController;
import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.Component;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MqttService {

    private MeasuramentService measuramentService;
    private AquariumService aquariumService;

    @Autowired
    public MqttService(MeasuramentService measuramentService, AquariumService aquariumService){
        this.measuramentService = measuramentService;
        this.aquariumService = aquariumService;
    }

    public MqttService() {}


    public IMqttClient mqttClient(String clientId, String brokerUrl, String username, String password) throws MqttException{
        MqttConnectOptions mqttConnectOptions = mqttConnectOptions(username,password);
        IMqttClient mqttClient = new MqttClient(brokerUrl, clientId);

        if(mqttClient.isConnected()){
            System.out.println("Užívateľ je už pripojeny");
            mqttClient.disconnect();
        }
        mqttClient.setCallback(new MqttCall());
        mqttClient.connect(mqttConnectOptions);
        System.out.println("Connected");
        return mqttClient;
    }

    public MqttConnectOptions mqttConnectOptions(String username, String password){
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setKeepAliveInterval(60);
        mqttConnectOptions.setAutomaticReconnect(true);
        return mqttConnectOptions;
    }

    public void sendData(Component component) throws Exception {
        String publisherId = UUID.randomUUID().toString();
        Aquarium aquarium = aquariumService.get(component.getAquariumId());
//        MqttComponentController mqttComponentController = new MqttComponentController(mqttClient(publisherId,aquarium.getBroker(), aquarium.getUsername(), aquarium.getPassword()), component);
//        mqttComponentController.call();
    }

    public void getData() throws MqttException {
        String subscriberId = UUID.randomUUID().toString();
        MqttComponentController mqttComponentController = new MqttComponentController(mqttClient(subscriberId,"tcp://147.175.125.215:1883", "vojs","Terror123456."));
        mqttComponentController.inbound("BaJoP1/4/WQLTP1/1");
    }
}
