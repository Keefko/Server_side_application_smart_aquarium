package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Notification;
import com.smartaquarium.smartaquarium.repository.NotificationRepository;
import com.smartaquarium.smartaquarium.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getUserNotifications(Integer id) {
        return notificationRepository.getUserNotifications(id);
    }

    @Override
    public List<Notification> getAquariumNotifications(Integer id) {
        return notificationRepository.getAquariumNotifications(id);
    }

    @Override
    public Notification get(int id) {
        Optional<Notification> optional = notificationRepository.findById(id);
        Notification notification = null;
        if(optional.isPresent()){
            notification = optional.get();
        }
        return notification;
    }

    @Override
    public Notification getAquariumNotificationByProperty(Integer aquariumId, String property) {
        return notificationRepository.getAquariumNotificationByProperty(aquariumId,property);
    }

    @Override
    public void add(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public void deleteById(int id) {
        notificationRepository.deleteById(id);
    }
}
