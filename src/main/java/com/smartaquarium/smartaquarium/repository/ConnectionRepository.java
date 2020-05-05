package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConnectionRepository extends JpaRepository<Connection, Integer> {

    @Query("SELECT c FROM Connection c WHERE c.aquariumId = ?1")
    Connection getByAquariumId(Integer aquariumId);

    @Query("DELETE FROM Connection c WHERE c.aquariumId = ?1")
    void deleteByAquariumId(Integer aquariumId);
}