package com.smartaquarium.smartaquarium.MqttControllers;

import com.smartaquarium.smartaquarium.entity.Component;
import com.smartaquarium.smartaquarium.service.ComponentService;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;

public class LightController implements Callable<Void> {

    private IMqttClient client;

    @Autowired
    private ComponentService componentService;

    public LightController(IMqttClient client) {
        this.client = client;
    }

    @Override
    public Void call() throws Exception {

        if(!client.isConnected()){
            return  null;
        }
//        Component component = componentService.get();
//        String topic = componentService.get().getName();
//        MqttMessage msg = createMessage(component);
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
