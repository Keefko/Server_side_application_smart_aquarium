package com.smartaquarium.smartaquarium.MqttControllers;

import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.service.ComponentService;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;

public class LightController implements Callable<Void> {

    private IMqttClient client;
    private Component component;

    public LightController(IMqttClient client,Component component) {
        this.client = client;
        this.component = component;
    }

    @Override
    public Void call() throws Exception {

        if(!client.isConnected()){
            return  null;
        }
//        MqttMessage msg = createMessage(component);
//        msg.setQos(0);
//        msg.setRetained(true);
//        client.publish(topic,msg);
        return null;
    }

//    private MqttMessage createMessage(Component component){
//        byte[] payload = String.format().getBytes();
//        return new MqttMessage(payload);
//
//    }
}
