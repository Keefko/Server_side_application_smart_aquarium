package com.bachelor.smartaquarium;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartController {

    @GetMapping
    public String aquarium(){
        return "SmartAquarium";
    }

}
