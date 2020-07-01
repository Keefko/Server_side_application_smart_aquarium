package com.smartaquarium.smartaquarium.MqttControllers;

import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.service.MeasuramentService;
import com.smartaquarium.smartaquarium.service.handling.MeasuramentProccess;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class MqttCall implements MqttCallback {

    private MeasuramentProccess measuramentProccess;
    private MeasuramentService measuramentService;
    @Autowired
    public MqttCall(MeasuramentProccess measuramentProccess) {
        this.measuramentProccess = measuramentProccess;
    }

    public MqttCall(){

    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String payload = new String(mqttMessage.getPayload());
        String[] data = payload.split(",");
        Timestamp timestamp = Timestamp.valueOf(data[0]);
        int ph = Integer.parseInt(data[1]);
        int orp = Integer.parseInt(data[2]);
        Double temperature = Double.parseDouble(data[7]);
        Measurament measurament = new Measurament(15425,ph,orp,temperature,timestamp);
        measuramentProccess.measuramentControl(measurament);
        measuramentService.add(measurament);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken){
        try {
            System.out.println(iMqttDeliveryToken.getMessage());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
