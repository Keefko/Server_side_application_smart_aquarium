package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    List<Notification> getUserNotifications(Integer id);
    List<Notification> getAquariumNotifications(Integer aquariumId);
    Notification get(int id);
    Notification getAquariumNotificationByProperty(Integer aquariumId, String property);
    Integer add(Notification notification);
    void deleteById(int id);
}
