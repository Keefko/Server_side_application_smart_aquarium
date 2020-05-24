package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.repository.MeasuramentRepository;
import com.smartaquarium.smartaquarium.service.MeasuramentService;
import com.smartaquarium.smartaquarium.service.handling.MeasuramentProccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class MeasuramentServiceImpl implements MeasuramentService {

    private MeasuramentRepository measuramentRepository;

    @Autowired
    private MeasuramentProccess measuramentProccess;

    @Autowired
    public MeasuramentServiceImpl(MeasuramentRepository measuramentRepository) {
        this.measuramentRepository = measuramentRepository;
    }

    @Override
    public List<Measurament> getAllMeasuramentByAquariumId(Integer aquariumId) {
        return measuramentRepository.getAllMeasuramentByAquariumId(aquariumId);
    }

    @Override
    public List<Measurament> getAllMeasuramentByDate(Integer aquariumId, Timestamp from, Timestamp to) {
        return measuramentRepository.getAllMeasuramentByDate(aquariumId,from,to);
    }

    @Override
    public Measurament getLastMeasurament(Integer aquariumId) {
        return measuramentRepository.getLastMeasurament(aquariumId);
    }

    @Override
    public Measurament get(Integer id) {
        Optional<Measurament> optional = measuramentRepository.findById(id);
        Measurament measurament = null;
        if(optional.isPresent()){
            measurament = optional.get();
        }
        return measurament;
    }

    @Override
    public void add(Measurament measurament) {
        measuramentRepository.save(measurament);
        measuramentProccess.measuramentControl(measurament);
    }

    @Override
    public void deleteById(Integer id) {
        measuramentRepository.deleteById(id);
    }

    @Override
    public void deleteAllByAquariumId(Integer aquariumId) {
        measuramentRepository.deleteAllByAquariumId(aquariumId);
    }

    @Override
    public int getPhAvg(Integer aquariumdId, Timestamp from, Timestamp to, String interval) {

        switch (interval){

            case "hour":

        }

        return 0;
    }

    @Override
    public int getOrpAvg(Integer aquariumdId, Timestamp from, Timestamp to, String interval) {
        return 0;
    }


    @Override
    public Double getThermoAvg(Integer aquariumdId, Timestamp from, Timestamp to, String interval) {
        return null;
    }

}
