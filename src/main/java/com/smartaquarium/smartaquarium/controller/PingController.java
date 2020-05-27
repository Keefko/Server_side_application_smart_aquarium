package com.smartaquarium.smartaquarium.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping
    public ResponseEntity ping(){
        return new ResponseEntity("Server funguje", HttpStatus.OK);
    }
}
