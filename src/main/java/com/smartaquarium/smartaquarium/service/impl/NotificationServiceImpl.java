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
    public List<Notification> getUserNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification get(int id) {
        Optional<Notification> optional = notificationRepository.findById(id);
        Notification notification = null;
        if(optional.isPresent()){
            notification = optional.get();
        } else {
            throw new RuntimeException("Notifikácia s id" + id + "neexistuje");
        }
        return notification;
    }

    @Override
    public Notification getAquariumNotificationByProperty(Integer aquariumId, String property) {
        return notificationRepository.getAquariumNotificationByProperty(aquariumId,property);
    }

    @Override
    public Integer add(Notification notification) {
        return notificationRepository.save(notification).getId();
    }

    @Override
    public void deleteById(int id) {
        notificationRepository.deleteById(id);
    }
}
