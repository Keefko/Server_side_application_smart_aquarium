package com.smartaquarium.smartaquarium.service.request;

import com.smartaquarium.smartaquarium.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MeasuramentProccess {

    @Autowired
    NotificationRepository notificationRepository;

    public MeasuramentProccess() {
    }

}
