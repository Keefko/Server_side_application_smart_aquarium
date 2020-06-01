package com.smartaquarium.smartaquarium.MqttControllers;

import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.service.MeasuramentService;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MqttComponentController {

    private IMqttClient client;

    public MqttComponentController(IMqttClient client) {
        this.client = client;
    }

    public MqttComponentController() {
    }


    public void outbound(Component component) throws MqttException {

        MqttMessage msg = createMessage(component);
        msg.setQos(0);
        msg.setRetained(true);
        try {
            client.publish(component.getTopic(), msg);
        }catch (MqttException me){
            me.printStackTrace();
        }

    }

    public void inbound(final String topic) throws MqttException {
        try {
            client.subscribe(topic);
        } catch (MqttException me){
            me.printStackTrace();
        }
    }

    private MqttMessage createMessage(Component component){
        byte[] payload = String.format("%d %d %s %b %d", component.getId(), component.getAquariumId(), component.getName(),component.getTurnOn(),component.getCyklus()).getBytes();
        return new MqttMessage(payload);
    }


}
