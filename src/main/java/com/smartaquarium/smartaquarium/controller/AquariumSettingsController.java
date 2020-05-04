package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("settings")
public class AquariumSettingsController {

    private AquariumSettingsService aquariumSettingsService;

    @Autowired
    public AquariumSettingsController(AquariumSettingsService aquariumSettingsService) {
        this.aquariumSettingsService = aquariumSettingsService;
    }

    @GetMapping("/aquarium/{id}")
    public AquariumSettings getSettingByAquariumId(@PathVariable Integer id){
        return aquariumSettingsService.getSettingByAquariumId(id);
    }

    @GetMapping("/{id}")
    public AquariumSettings get(@PathVariable Integer id){
        AquariumSettings aquariumSettings = aquariumSettingsService.get(id);
        if (aquariumSettings == null){
            throw new RuntimeException("Nastavenie s id" + id + "neexistuje");
        }
        return aquariumSettings;
    }

    @PostMapping("/add")
    public void add(@RequestBody AquariumSettings aquariumSettings){
        aquariumSettingsService.add(aquariumSettings);
    }

    @PutMapping
    public AquariumSettings updateSettings(@RequestBody AquariumSettings aquariumSettings){
        aquariumSettingsService.add(aquariumSettings);
        return aquariumSettings;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        aquariumSettingsService.deleteById(id);
    }


}
