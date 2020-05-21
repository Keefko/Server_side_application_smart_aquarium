package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface AquariumSettingsRepository extends JpaRepository<AquariumSettings, Integer> {

    @Query("SELECT a FROM AquariumSettings a WHERE a.aquariumId = ?1")
    AquariumSettings getSettingByAquariumId(Integer aquariumId);

    @Transactional
    @Modifying
    @Query("DELETE FROM AquariumSettings a WHERE a.aquariumId = ?1")
    void deleteByAquariumId(Integer aquariumId);

}
