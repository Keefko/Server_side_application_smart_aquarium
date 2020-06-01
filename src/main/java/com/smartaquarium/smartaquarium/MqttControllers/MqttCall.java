package com.smartaquarium.smartaquarium.MqttControllers;

import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.service.MeasuramentService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttCall implements MqttCallback {

    private MeasuramentService measuramentService;

    @Autowired
    public MqttCall(MeasuramentService measuramentService) {
        this.measuramentService = measuramentService;
    }

    public MqttCall(){

    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message received: " + new String(mqttMessage.getPayload()));
//        String payload = new String(mqttMessage.getPayload());
//        Measurament measurament = new Measurament();
//        measuramentService.add(measurament);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken){
        try {
            System.out.println(iMqttDeliveryToken.getMessage());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
