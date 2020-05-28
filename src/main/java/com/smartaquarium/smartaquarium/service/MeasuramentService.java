package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.service.handling.MeasuramentGraphData;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Service
public interface MeasuramentService {

    List<Measurament> getAllMeasuramentByAquariumId(Integer aquariumId);
    List<Measurament> getAllMeasuramentByDate(Integer aquariumId, Timestamp from, Timestamp to);
    Measurament getLastMeasurament(Integer aquariumId);
    Measurament get(Integer id);
    void add(Measurament measurament);
    void deleteById(Integer id);
    void deleteAllByAquariumId(Integer aquariumId);
    List<Object> getPhAvg(Integer aquariumdId, Timestamp from, Timestamp to);
    List<Object> getPhAvgW(Integer aquariumdId, Timestamp from, Timestamp to);
    List<Object> getOrpAvg(Integer aquariumdId,Timestamp from, Timestamp to);
    List<Object> getOrpAvgW(Integer aquariumdId,Timestamp from, Timestamp to);
    List<Object> getThermoAvg(Integer aquariumdId,Timestamp from, Timestamp to);
    List<Object> getThermoAvgW(Integer aquariumdId,Timestamp from, Timestamp to);
}
