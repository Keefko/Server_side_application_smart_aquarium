package com.bachelor.smartaquarium.Repository;

import com.bachelor.smartaquarium.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentsRepository extends JpaRepository<Component, Integer> {
}
