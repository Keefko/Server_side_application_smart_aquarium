package com.smartaquarium.smartaquarium.controller;

import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.service.MeasuramentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("measurament")
public class MeasuramentController {

    private MeasuramentService measuramentService;

    @Autowired
    public MeasuramentController(MeasuramentService measuramentService) {
        this.measuramentService = measuramentService;
    }

    @GetMapping("/aquarium/{id}")
    public List<Measurament> getAllMeasuramentByAquariumId(@PathVariable Integer id){
        return measuramentService.getAllMeasuramentByAquariumId(id);
    }

    @GetMapping("/{id}/{from}/{to}")
    public List<Measurament> getAllMeasuramentByDate(@PathVariable Integer id, @PathVariable Timestamp from, @PathVariable Timestamp to){
        return measuramentService.getAllMeasuramentByDate(id,from,to);
    }

    @GetMapping("/last/{id}")
    public ResponseEntity getLastMeasurament(@PathVariable Integer id){
        Measurament measurament = measuramentService.getLastMeasurament(id);
        if(measurament != null){
            return new ResponseEntity<>(measurament, HttpStatus.OK);
        }
        return new ResponseEntity<>("Akvárium s id :" + id + "neexistuje", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        Measurament measurament = measuramentService.get(id);
        if(measurament != null){
            return new ResponseEntity<>(measurament, HttpStatus.OK);
        }
        return new ResponseEntity<>("Meranie s id :" + id + "neexistuje", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ph/{id}/{from}/{to}/{interval}")
    public ResponseEntity getAvgPh(@PathVariable Integer id,@PathVariable String from, @PathVariable String to,@PathVariable String interval) throws ParseException {
        List<Object[]> phs = null;
        Timestamp timeFrom = Timestamp.valueOf(from);
        Timestamp timeTo = Timestamp.valueOf(to);
        switch (interval){
            case "hour":
                phs = measuramentService.getPhAvg(id,timeFrom,timeTo);
                break;
            case "day":
                phs = measuramentService.getPhAvgD(id,timeFrom,timeTo);
                break;
            case "week":
                phs = measuramentService.getPhAvgW(id,timeFrom,timeTo);
                break;
        }

        List<HashMap<String, String>> response = getHashMaps(phs,interval);
        return new ResponseEntity(response, HttpStatus.OK);
    }



    @GetMapping("/orp/{id}/{from}/{to}/{interval}")
    public ResponseEntity getAvgOrp(@PathVariable Integer id,@PathVariable String from, @PathVariable String to,@PathVariable String interval) throws ParseException {
        List<Object[]> orps = null;
        Timestamp timeFrom = Timestamp.valueOf(from);
        Timestamp timeTo = Timestamp.valueOf(to);
        switch (interval){
            case "hour":
                orps = measuramentService.getOrpAvg(id,timeFrom,timeTo);
                break;
            case "day":
                orps = measuramentService.getOrpAvgD(id,timeFrom,timeTo);
                break;
            case "week":
                orps = measuramentService.getOrpAvgW(id,timeFrom,timeTo);
                break;
        }

        List<HashMap<String, String>> response = getHashMaps(orps,interval);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/temperature/{id}/{from}/{to}/{interval}")
    public ResponseEntity getAvgThermo(@PathVariable Integer id,@PathVariable String from, @PathVariable String to,@PathVariable String interval) throws ParseException {
        List<Object[]> temperatures = null;
        Timestamp timeFrom = Timestamp.valueOf(from);
        Timestamp timeTo = Timestamp.valueOf(to);
        switch (interval){
            case "hour":
                temperatures = measuramentService.getThermoAvg(id,timeFrom,timeTo);
                break;
            case "day":
                temperatures = measuramentService.getThermoAvgD(id,timeFrom,timeTo);
                break;
            case "week":
                temperatures = measuramentService.getThermoAvgW(id,timeFrom,timeTo);
                break;
        }
        List<HashMap<String, String>> response = getHashMaps(temperatures, interval);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Measurament measurament){
            measuramentService.add(measurament);
            return new ResponseEntity<>(measurament, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateMeasurament(@RequestBody Measurament measurament){
        Measurament measurament1 = measuramentService.get(measurament.getId());

        if(measurament1 != null) {
            measuramentService.add(measurament);
            return new ResponseEntity<>(measurament, HttpStatus.OK);
        }
        return new ResponseEntity<>("Dané meranie už existuje", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        Measurament measurament = measuramentService.get(id);
        if(measurament != null){
            measuramentService.deleteById(id);
            return new ResponseEntity<>(measurament, HttpStatus.OK);
        }
        return new ResponseEntity<>("Meranie s daným id neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAllByAquariumId(@PathVariable Integer id){
        Measurament measurament = measuramentService.get(id);
        if(measurament != null){
            measuramentService.deleteAllByAquariumId(id);
            return new ResponseEntity<>("Merania pre akvárium boli uspesne zmazane", HttpStatus.OK);
        }
        return new ResponseEntity<>("Akvárium s daným id neexistuje", HttpStatus.NOT_FOUND);
    }


    private List<HashMap<String, String>> getHashMaps(List<Object[]> values, String interval) throws ParseException {
        HashMap<String, String> map = new HashMap<>();
        List<HashMap<String, String>> response = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = null;
        Date newDate = null;
        SimpleDateFormat sdf = null;
        for (int i = 0; i < values.size(); i++) {
            String value = String.valueOf(values.get(i)[0]);
            String time = String.valueOf(values.get(i)[1]);
            switch(interval){
                case "hour":
                    simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    newDate = simpleDateFormat.parse(time);
                    sdf= new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
                    response.add(response(map,sdf, value, newDate));
                    break;
                case "day" :
                    simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    newDate = simpleDateFormat.parse(time);
                    sdf= new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                    response.add(response(map,sdf, value,newDate));
                    break;
                case "week" :
                    map.put("value", time);
                    map.put("time", value);
                    response.add(map);
                    break;
            }

        }
        return response;
    }

    private HashMap<String, String> response(HashMap<String, String> map, SimpleDateFormat sdf, String value, Date newDate) {
        String date = sdf.format(newDate);
        map.put("value", value);
        map.put("time", date);
        return map;
    }
}
