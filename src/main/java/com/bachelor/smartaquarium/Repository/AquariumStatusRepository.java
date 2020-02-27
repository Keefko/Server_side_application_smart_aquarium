package com.bachelor.smartaquarium.Repository;

import com.bachelor.smartaquarium.entity.AquariumStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AquariumStatusRepository  extends JpaRepository<AquariumStatus,Integer> {
}
