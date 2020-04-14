package com.bachelor.smartaquarium.Repository;

import com.bachelor.smartaquarium.entity.MeasuramentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasuramentDataRepository extends JpaRepository<MeasuramentData, Integer> {
}
