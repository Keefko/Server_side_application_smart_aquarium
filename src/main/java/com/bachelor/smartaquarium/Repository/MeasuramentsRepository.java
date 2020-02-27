package com.bachelor.smartaquarium.Repository;

import com.bachelor.smartaquarium.entity.Measuraments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasuramentsRepository extends JpaRepository<Measuraments, Long> {
}
