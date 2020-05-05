package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.Aquarium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AquariumRepository extends JpaRepository<Aquarium, Integer> {

    @Query("SELECT a FROM Aquarium a WHERE a.userId = ?1")
    List<Aquarium> findAllByUserId(Integer userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Aquarium a WHERE a.userId = ?1")
    void DeleteAllByUserId(Integer userId);

}
