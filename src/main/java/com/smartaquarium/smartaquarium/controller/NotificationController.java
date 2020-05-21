package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Notification;
import com.smartaquarium.smartaquarium.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("notification")
public class NotificationController {

    private NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<Notification> getUserNotifications(){

    }
    Notification get(int id){

    }
    Integer add(Notification notification){

    }
    void deleteById(int id){
        
    }
}
