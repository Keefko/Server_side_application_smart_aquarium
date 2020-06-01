package com.smartaquarium.smartaquarium.service.handling;


import com.smartaquarium.smartaquarium.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteRequest {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private AquariumSettingsRepository aquariumSettingsRepository;

    @Autowired
    private MeasuramentRepository measuramentRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private MqttBrokerRepository mqttBrokerRepository;

    public void deleteAquariumConexions(Integer aquariumId){
        connectionRepository.deleteByAquariumId(aquariumId);
        measuramentRepository.deleteAllByAquariumId(aquariumId);
        aquariumSettingsRepository.deleteByAquariumId(aquariumId);
        componentRepository.deleteByAquariumId(aquariumId);
        notificationRepository.deleteByAquariumId(aquariumId);
        mqttBrokerRepository.deleteByAquariumId(aquariumId);
    }

}
