package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.service.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aquariums")
public class AquariumController {

    private AquariumService aquariumService;

    @Autowired
    public AquariumController(AquariumService aquariumService) {
        this.aquariumService = aquariumService;
    }

    @GetMapping
    public List<Aquarium> getAquariums(){
        return aquariumService.getAquariums();
    }

    @GetMapping("/user/{id}")
    public List<Aquarium> getAllUsersAquariums(@PathVariable Integer id){
        return aquariumService.getAllUsersAquariums(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        Aquarium aquarium = aquariumService.get(id);
        if(aquarium == null){
           return new ResponseEntity<>("Nepodarilo sa nájst akvárium s id" + id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aquarium, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add (@RequestBody Aquarium aquarium){
        Aquarium aqua = aquariumService.get(aquarium.getId());
        if(aqua == null) {
            aquariumService.add(aquarium);
            return new ResponseEntity<>(aquarium, HttpStatus.OK);
        }
        return new ResponseEntity<>("Akvárium s id" + aquarium.getId() + "už existuje",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity updateAquarium(@RequestBody Aquarium aquarium){
        if(aquariumService.get(aquarium.getId())!= null){
            aquariumService.add(aquarium);
            return new ResponseEntity<>(aquarium,HttpStatus.OK);
        }
        return  new ResponseEntity<>("Zadané akvárium neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        Aquarium aquarium = aquariumService.get(id);
        if(aquarium != null) {
            aquariumService.deleteById(id);
            return  new ResponseEntity<>("Akvárium s id " + id + " bolo zmazané" ,HttpStatus.OK);
        }
        return  new ResponseEntity<>("Zadané akvárium neexistuje", HttpStatus.NOT_FOUND);
    }

}
