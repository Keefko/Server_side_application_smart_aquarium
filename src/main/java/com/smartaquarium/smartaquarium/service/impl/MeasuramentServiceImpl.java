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
        List<Measurament> last = measuramentRepository.getLastMeasurament(aquariumId);
        return last.get(0);
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
    public List<Object[]> getPhAvg(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getPhAvg(aquariumdId,from,to);
    }

    @Override
    public List<Object[]> getPhAvgD(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getPhAvgD(aquariumdId,from,to);
    }

    @Override
    public List<Object[]> getPhAvgW(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getPhAvgW(aquariumdId,from,to);

    }

    @Override
    public List<Object[]> getOrpAvg(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getOrpAvg(aquariumdId,from,to);
    }

    @Override
    public List<Object[]> getOrpAvgD(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getOrpAvgD(aquariumdId,from,to);
    }

    @Override
    public List<Object[]> getOrpAvgW(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getOrpAvgW(aquariumdId,from,to);

    }

    @Override
    public List<Object[]> getThermoAvg(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getThermoAvg(aquariumdId,from,to);
    }

    @Override
    public List<Object[]> getThermoAvgD(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getThermoAvgD(aquariumdId,from,to);
    }

    @Override
    public List<Object[]> getThermoAvgW(Integer aquariumdId, Timestamp from, Timestamp to) {
        return measuramentRepository.getThermoAvgW(aquariumdId,from,to);
    }

}
