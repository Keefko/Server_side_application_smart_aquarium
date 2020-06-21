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
    public ResponseEntity getUserNotifications(@PathVariable int id){
        List<Object[]> notifications = notificationService.getUserNotifications(id);
        HashMap<String, String> map = new HashMap<>();
        List<HashMap<String, String>> response = new ArrayList<>();

        for(int i = 0; i < notifications.size(); i++){
            map.put("id", String.valueOf(notifications.get(i)[0]));
            map.put("aquariumId",String.valueOf(notifications.get(i)[1]));
            map.put("property",String.valueOf(notifications.get(i)[2]));
            map.put("text",String.valueOf(notifications.get(i)[3]));
            map.put("visible",String.valueOf(notifications.get(i)[4]));
            map.put("name",String.valueOf(notifications.get(i)[5]));
            response.add(map);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
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
