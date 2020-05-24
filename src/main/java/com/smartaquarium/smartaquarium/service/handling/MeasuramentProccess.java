package com.smartaquarium.smartaquarium.service.handling;

import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.entity.Connection;
import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.entity.Notification;
import com.smartaquarium.smartaquarium.repository.NotificationRepository;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
import com.smartaquarium.smartaquarium.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class MeasuramentProccess {

    private NotificationRepository notificationRepository;
    private AquariumSettingsService aquariumSettingsService;
    private ConnectionService connectionService;

    @Autowired
    public MeasuramentProccess(NotificationRepository notificationRepository, AquariumSettingsService aquariumSettingsService, ConnectionService connectionService) {
        this.notificationRepository = notificationRepository;
        this.aquariumSettingsService = aquariumSettingsService;
        this.connectionService = connectionService;
    }

    @NonNull
    public void measuramentControl(Measurament measurament){
        AquariumSettings aquariumSettings = aquariumSettingsService.getSettingByAquariumId(measurament.getAquariumId());
        Connection connection = connectionService.getByAquariumId(measurament.getAquariumId());

        if(aquariumSettings ==  null){
            throw new RuntimeException("Akvárium nemá nastavenia");
        }

        if(connection == null) {
            Boolean phSenzor = false;
            Boolean orpSenzor = false;
            Boolean thermometer = false;

            if(measurament.getPh() != 0){
                phSenzor = true;
            }

            if(measurament.getOrp() != 0){
                orpSenzor = true;
            }

            if(measurament.getTemperature() != 0.0){
                thermometer = true;
            }
            Connection newCon = new Connection(measurament.getAquariumId(),phSenzor,orpSenzor,thermometer,false, false, false);
            connectionService.add(newCon);
        }

        int phWarning = phControl(measurament.getPh(),aquariumSettings.getPh());
        int orpWarning = orpControl(measurament.getOrp(), aquariumSettings.getOrp());
        Double temperatureWarning = temperatureControl(measurament.getTemperature(), aquariumSettings.getTemperature());

        if( phWarning != 0){
            addNotification(measurament, phWarning, "ph" );
        }

        if( orpWarning != 0){
            addNotification(measurament, orpWarning, "orp" );
        }

        if( temperatureWarning != 0.0){
            addNotification(measurament, (int)Math.round(temperatureWarning), "temperature" );
        }
    }

    private void addNotification(Measurament measurament, int value, String property) {
        String text = null;
        if(value > 0) {
            text = "Hladina " + property + " prekročila hranicu o " + value;
        } else {
            text ="Hladina " + property + " klesla pod hranicu o " + Math.abs(value);
        }
        Notification notification = new Notification(measurament.getAquariumId(), property, text, true);
        notificationRepository.save(notification);
    }


    private int phControl(int ph, int setPh){
        double value = setPh;
        double result = 0.0;

        if(setPh > 8) {
           result = calculatePercentage(value, 1.2);
        } else {
            result = calculatePercentage(value, 1.3);
        }

        int difference = ph - setPh;
        if( difference > result || difference < -result){
            return difference;
        }
        return  0;
    }

    private int orpControl(int orp, int setOrp){
        double value = setOrp;
        double result = calculatePercentage(value, 1.2);
        int difference = orp - setOrp;
        if( difference > result || difference < -result){
            return difference;
        }
        return 0;
    }

    private Double temperatureControl(Double temperature, Double setTemperature){
        double result = calculatePercentage(setTemperature, 1.2);
        double difference = temperature - setTemperature;
        if( difference > result || difference < -result){
            return difference;
        }
        return 0.0;
    }

    private double calculatePercentage(Double value, Double percentage){
        return  value/percentage;
    }
}
