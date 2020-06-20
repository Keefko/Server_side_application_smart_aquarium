package com.smartaquarium.smartaquarium.service.impl;


import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import com.smartaquarium.smartaquarium.repository.AquariumRepository;
import com.smartaquarium.smartaquarium.repository.AquariumSettingsRepository;
import com.smartaquarium.smartaquarium.service.AquariumSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AquariumSettingServiceImpl implements AquariumSettingsService {

    private AquariumSettingsRepository aquariumSettingsRepository;
    private AquariumRepository aquariumRepository;

    @Autowired
    public AquariumSettingServiceImpl(AquariumSettingsRepository aquariumSettingsRepository, AquariumRepository aquariumRepository) {
        this.aquariumSettingsRepository = aquariumSettingsRepository;
        this.aquariumRepository = aquariumRepository;
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
        Optional<Aquarium> aquarium = aquariumRepository.findById(aquariumSettings.getAquariumId());
        if(aquarium.isPresent()){
            Aquarium newAquarium = aquarium.get();
            newAquarium.setName(aquariumSettings.getName());
            aquariumRepository.save(newAquarium);
        }
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
