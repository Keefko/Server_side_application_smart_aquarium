package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getSettingByAquariumId(@PathVariable Integer id){
        AquariumSettings aquariumSettings = aquariumSettingsService.getSettingByAquariumId(id);
        if(aquariumSettings != null) {
            return new ResponseEntity<>(aquariumSettings, HttpStatus.OK);
        }
        return new ResponseEntity<>("Akvárium nemá žiadne nastavenia", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        AquariumSettings aquariumSettings = aquariumSettingsService.get(id);
        if (aquariumSettings == null){
            return new ResponseEntity<>("Nastavenie s id" + id + "neexistuje", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aquariumSettings,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity  add(@RequestBody AquariumSettings aquariumSettings){
        AquariumSettings aquariumSettings1 = aquariumSettingsService.getSettingByAquariumId(aquariumSettings.getAquariumId());
        if(aquariumSettings1 == null) {
            aquariumSettingsService.add(aquariumSettings);
            return new ResponseEntity<>(aquariumSettings,HttpStatus.OK);
        }
        return new ResponseEntity<>("Nastavenie pre dáne akvárium už existuje",HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity  updateSettings(@RequestBody AquariumSettings aquariumSettings){
        AquariumSettings aquariumSettings1 = aquariumSettingsService.get(aquariumSettings.getId());
        if(aquariumSettings1 != null) {
            aquariumSettingsService.add(aquariumSettings);
            return  new ResponseEntity<>(aquariumSettings, HttpStatus.OK);
        }
        return new ResponseEntity<>("Zadané nástavenie neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity  deleteById(@PathVariable Integer id){
        AquariumSettings aquariumSettings = aquariumSettingsService.get(id);
        if(aquariumSettings != null) {
            aquariumSettingsService.deleteById(id);
            return new ResponseEntity<>("Nastavenie bolo zmazané", HttpStatus.OK);
        }
        return new ResponseEntity<>("Zadané nástavenie neexistuje", HttpStatus.NOT_FOUND);
    }
}
