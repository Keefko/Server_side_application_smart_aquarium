package com.smartaquarium.smartaquarium.controller;

import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.service.MeasuramentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("measurament")
public class MeasuramentController {

    private MeasuramentService measuramentService;

    @Autowired
    public MeasuramentController(MeasuramentService measuramentService) {
        this.measuramentService = measuramentService;
    }


    @GetMapping("/aquarium/{id]")
    public List<Measurament> getAllMeasuramentByAquariumId(@PathVariable Integer id){
        return measuramentService.getAllMeasuramentByAquariumId(id);
    }

    @GetMapping("/{id}/{from}/{to]")
    public List<Measurament> getAllMeasuramentByDate(@PathVariable Integer id, @PathVariable Timestamp from, @PathVariable Timestamp to){
        return measuramentService.getAllMeasuramentByDate(id,from,to);
    }

    @GetMapping("/last/{id}")
    public Measurament getLastMeasurament(@PathVariable Integer id){
        return measuramentService.getLastMeasurament(id);
    }

    @GetMapping("/{id}")
    public Measurament get(@PathVariable Integer id){
        Measurament measurament = measuramentService.get(id);
        if(measurament == null){
            throw new RuntimeException("Meranie s id :" + id + "neexistuje");
        }

        return  measurament;
    }

    @PostMapping("/add")
    public void add(@RequestBody Measurament measurament){
        measuramentService.add(measurament);
    }

    @PutMapping
    public Measurament updateMeasurament(@RequestBody Measurament measurament){
        measuramentService.add(measurament);
        return measurament;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        measuramentService.deleteById(id);
    }

    @DeleteMapping("/aquarium/{id}")
    public void deleteAllByAquariumId(@PathVariable Integer id){
        measuramentService.deleteAllByAquariumId(id);
    }
}
