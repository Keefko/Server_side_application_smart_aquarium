package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ComponentRepository extends JpaRepository<Component, Integer> {


    @Query("SELECT c FROM Component c WHERE c.aquariumId = ?1")
    List<Component> getAllComponentsByAquariumId(Integer aquariumId);

}
