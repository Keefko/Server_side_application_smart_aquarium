package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AquariumSettingsService {


    AquariumSettings get(Integer id);
    void add(AquariumSettings aquariumSettings);
    AquariumSettings getSettingByAquariumId(Integer aquariumId);
    void deleteById(Integer id);
}
