package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComponentRepository extends JpaRepository<Component, Integer> {
}
