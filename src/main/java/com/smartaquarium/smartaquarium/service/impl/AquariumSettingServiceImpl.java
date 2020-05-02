package com.smartaquarium.smartaquarium.service.impl;


import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.repository.AquariumSettingsRepository;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AquariumSettingServiceImpl implements AquariumSettingsService {

    private AquariumSettingsRepository aquariumSettingsRepository;

    @Autowired
    public AquariumSettingServiceImpl(AquariumSettingsRepository aquariumSettingsRepository) {
        this.aquariumSettingsRepository = aquariumSettingsRepository;
    }

    @Override
    public List<AquariumSettings> getAllSettingsByUserId(Integer userId) {
        return aquariumSettingsRepository.getAllSettingsByUserId(userId);
    }

    @Override
    public AquariumSettings get(Integer id) {
        Optional<AquariumSettings> optional = aquariumSettingsRepository.findById(id);
        AquariumSettings aquariumSettings = null;
        if(optional.isPresent()){
            aquariumSettings = optional.get();
        }else {
            throw new RuntimeException("Nenašlo sa nastavenie s id:" + id);
        }

        return aquariumSettings;
    }

    @Override
    public void add(AquariumSettings aquariumSettings) {
        aquariumSettingsRepository.save(aquariumSettings);
    }

    @Override
    public AquariumSettings getSettingByAquariumId(Integer aquariumId) {
        return aquariumSettingsRepository.getSettingByAquariumId(aquariumId);
    }

    @Override
    public void deleteById(Integer id) {
        aquariumSettingsRepository.deleteById(id);
    }
}
