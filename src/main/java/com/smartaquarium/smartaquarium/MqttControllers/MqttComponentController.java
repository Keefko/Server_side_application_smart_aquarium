package com.smartaquarium.smartaquarium.MqttControllers;

import com.smartaquarium.smartaquarium.entity.Component;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;


import java.util.concurrent.Callable;

@Service
public class MqttComponentController implements Callable<Void> {

    private IMqttClient client;
    private Component component;

    public MqttComponentController(IMqttClient client) {
        this.client = client;
    }

    public MqttComponentController() {
    }

    @Override
    public Void call() throws Exception {

        if(!client.isConnected()){
            return  null;
        }
        MqttMessage msg = createMessage(component);
        msg.setQos(0);
        msg.setRetained(true);
        client.publish(component.getTopic(),msg);
        return null;
    }

    public void inbound(final String topic) throws MqttException {
        client.subscribe(topic);
    }

    private MqttMessage createMessage(Component component){
        byte[] payload = String.format("%d,%d,%s,%o,%d", component.getId(), component.getAquariumId(), component.getName(),component.getTurnOn(),component.getCyklus()).getBytes();
        return new MqttMessage(payload);
    }


}
