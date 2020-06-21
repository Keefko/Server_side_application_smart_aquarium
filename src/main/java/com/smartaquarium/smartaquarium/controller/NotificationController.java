package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.Notification;
import com.smartaquarium.smartaquarium.service.AquariumService;
import com.smartaquarium.smartaquarium.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("notification")
public class NotificationController {

    private NotificationService notificationService;
    private AquariumService aquariumService;
    @Autowired
    public NotificationController(NotificationService notificationService, AquariumService aquariumService) {
        this.notificationService = notificationService;
        this.aquariumService = aquariumService;
    }

    @GetMapping("/user/{id}")
    public List<Notification>  getUserNotifications(@PathVariable int id){
        return notificationService.getUserNotifications(id);
    }

    @GetMapping("/aquarium/{id}")
    public List<Notification> getAquariumNotifications(@PathVariable int id){
        return notificationService.getAquariumNotifications(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable int id){
        Notification notification = notificationService.get(id);
        if(notification != null){
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }
        return new ResponseEntity<>("Notifikácia s takýmto id " + id + " neexistuje", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/{property}")
    public ResponseEntity getAquariumNotificationByProperty(@PathVariable int id , @PathVariable String property){
        Notification notification = notificationService.getAquariumNotificationByProperty(id,property);
        if(notification != null){
            return new ResponseEntity<>(notification,HttpStatus.OK);
        }
        return new ResponseEntity<>("Požadovaná notifikácia neexistuje", HttpStatus.NOT_FOUND);
    }
    @PutMapping
    public ResponseEntity update(Notification notification){
        Notification notification1 = notificationService.get(notification.getId());
        if(notification1 != null){
            notificationService.add(notification);
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }
        return new ResponseEntity<>("Notifikácia neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        Notification notification = notificationService.get(id);
        if(notification != null) {
            notificationService.deleteById(id);
            return new ResponseEntity<>("notifikácia s id" + id + "bola zmazaná" , HttpStatus.OK);
        }
        return new ResponseEntity<>("Notifikácia s id " + id +" neexistuje", HttpStatus.NOT_FOUND);
    }
}
