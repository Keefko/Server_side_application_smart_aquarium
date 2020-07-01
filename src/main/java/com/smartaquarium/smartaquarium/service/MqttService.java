package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.MqttControllers.MqttCall;
import com.smartaquarium.smartaquarium.MqttControllers.MqttComponentController;
import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.entity.MqttBroker;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MqttService {

    private MqttBrokerService mqttBrokerService;

    @Autowired
    public MqttService(MqttBrokerService mqttBrokerService){
        this.mqttBrokerService = mqttBrokerService;
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

    public void sendData(Component component) throws MqttException {
        String publisherId = UUID.randomUUID().toString();
        MqttBroker mqttBroker = mqttBrokerService.getBrokerDataByAquariumId(component.getAquariumId());
        MqttComponentController mqttComponentController = new MqttComponentController(mqttClient(publisherId,mqttBroker.getBrokerUrl(), mqttBroker.getUsername(), mqttBroker.getPassword()));
        mqttComponentController.outbound(component);
    }

    public void getData(Integer id, String topic) throws MqttException {
        String subscriberId = UUID.randomUUID().toString();
        MqttBroker mqttBroker = mqttBrokerService.getBrokerDataByAquariumId(id);
        MqttComponentController mqttComponentController = new MqttComponentController(mqttClient(subscriberId,mqttBroker.getBrokerUrl(), mqttBroker.getUsername(), mqttBroker.getPassword()));
        mqttComponentController.inbound(topic);
    }
}
