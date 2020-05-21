package com.smartaquarium.smartaquarium.service.request;


import com.smartaquarium.smartaquarium.repository.AquariumSettingsRepository;
import com.smartaquarium.smartaquarium.repository.ComponentRepository;
import com.smartaquarium.smartaquarium.repository.ConnectionRepository;
import com.smartaquarium.smartaquarium.repository.MeasuramentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteRequest {
    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private AquariumSettingsRepository aquariumSettingsRepository;

    @Autowired
    private MeasuramentRepository measuramentRepository;


    public void deleteAquariumConexions(Integer aquariumId){
        connectionRepository.deleteByAquariumId(aquariumId);
        measuramentRepository.deleteAllByAquariumId(aquariumId);
        aquariumSettingsRepository.deleteByAquariumId(aquariumId);
        componentRepository.deleteByAquariumId(aquariumId);
    }

}
