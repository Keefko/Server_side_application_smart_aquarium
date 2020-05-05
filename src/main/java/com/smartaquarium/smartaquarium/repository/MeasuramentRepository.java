package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.Measurament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

public interface MeasuramentRepository extends JpaRepository<Measurament, Integer> {

    @Query("SELECT m FROM Measurament m WHERE m.aquariumId = ?1")
    List<Measurament> getAllMeasuramentByAquariumId(Integer aquariumId);

    @Query("SELECT m FROM Measurament  m WHERE m.aquariumId = ?1 AND  m.createTime BETWEEN ?2 AND ?3 ")
    List<Measurament> getAllMeasuramentByDate(Integer aquariumId, Timestamp from, Timestamp to);

    @Transactional
    @Modifying
    @Query("DELETE FROM Measurament m WHERE m.aquariumId = ?1")
    void deleteAllByAquariumId(Integer aquariumId);

    @Query("SELECT m FROM Measurament m WHERE m.aquariumId = ?1")
    Measurament  getLastMeasurament(Integer aquariumId);


    //@Query("SELECT AVG(m) FROM Measurament m WHERE ")

}
