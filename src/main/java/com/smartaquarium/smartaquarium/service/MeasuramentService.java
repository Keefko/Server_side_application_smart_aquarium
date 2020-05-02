package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.Measurament;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface MeasuramentService {

    List<Measurament> getAllMeasuramentByAquariumId(Integer aquariumId);
    List<Measurament> getAllMeasuramentByDate(Integer aquariumId, Timestamp from, Timestamp to);
    Measurament get(Integer id);
    void add(Measurament measurament);
    void deleteById(Integer id);
    void deleteAllByAquariumId(Integer aquariumId);

}