package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.AquariumSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AquariumSettingsRepository extends JpaRepository<AquariumSettings, Integer> {

    @Query("SELECT a FROM AquariumSettings a WHERE a.userId = ?1")
    List<AquariumSettings> getAllSettingsByUserId(Integer userId);

    @Query("SELECT a FROM AquariumSettings a WHERE a.aquariumId = ?1")
    AquariumSettings getSettingByAquariumId(Integer aquariumId);
}
