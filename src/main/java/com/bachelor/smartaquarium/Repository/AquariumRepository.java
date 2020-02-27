package com.bachelor.smartaquarium.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bachelor.smartaquarium.entity.Aquarium;

public interface AquariumRepository extends JpaRepository< Aquarium, Long> {
}
