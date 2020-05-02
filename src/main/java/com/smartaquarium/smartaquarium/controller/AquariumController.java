package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.service.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Aquarium> getAllUsersAquariums(@PathVariable Integer userId){
        return aquariumService.getAllUsersAquariums(userId);
    }

    @GetMapping("/{id}")
    public Aquarium get(@PathVariable Integer id){
        Aquarium aquarium = aquariumService.get(id);
        if(aquarium == null){
            throw new RuntimeException("Akvárium s id :" + id + "neexistuje");
        }

        return  aquarium;
    }

    @PutMapping
    public Aquarium updateAquarium (@RequestBody Aquarium aquarium){
        aquariumService.add(aquarium);
        return aquarium;
    }

    @PostMapping("/add")
    public Integer add(@RequestBody Aquarium aquarium){
        return aquariumService.add(aquarium);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        aquariumService.deleteById(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteAllByUserId(@PathVariable Integer id){
        aquariumService.deleteAllByUserId(id);
    }

}
