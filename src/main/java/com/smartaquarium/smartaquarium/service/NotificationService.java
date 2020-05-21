package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    List<Notification> getUserNotifications();
    Notification get(int id);
    Integer add(Notification notification);
    void deleteById(int id);
}
