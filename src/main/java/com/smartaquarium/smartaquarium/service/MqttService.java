package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.mqtt.MqttCall;
import com.smartaquarium.smartaquarium.service.MeasuramentService;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class MqttService {

    private MeasuramentService measuramentService;

    @Autowired
    public MqttService(MeasuramentService measuramentService){
        this.measuramentService = measuramentService;
    }

    public MqttService() {

    }

    public void inbound(final String topic) throws MqttException {
        IMqttClient mqttClient = mqttClient("smartaquarium","tcp://147.175.125.215:1883");
        mqttClient.subscribe(topic);
    }

    public IMqttClient mqttClient(String clientId, String brokerUrl) throws MqttException{
        MqttConnectOptions mqttConnectOptions = mqttConnectOptions();
        IMqttClient mqttClient = new MqttClient(brokerUrl, clientId);

        if(mqttClient.isConnected()){
            System.out.println("Užívateľ je už pripojeny");
            mqttClient.disconnect();
        }
        mqttClient.setCallback(new MqttCall());
        mqttClient.connect(mqttConnectOptions);
        return mqttClient;
    }

    public MqttConnectOptions mqttConnectOptions(){
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName("vojs");
        mqttConnectOptions.setPassword("Terror123456.".toCharArray());
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setKeepAliveInterval(60);
        mqttConnectOptions.setAutomaticReconnect(true);
        return mqttConnectOptions;
    }
}
