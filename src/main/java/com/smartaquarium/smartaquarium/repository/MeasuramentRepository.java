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

    @Query(value = "SELECT m FROM Measurament m WHERE m.aquariumId = ?1 ORDER BY m.createTime ASC LIMIT 1", nativeQuery = true)
    Measurament  getLastMeasurament(Integer aquariumId);

    @Query("SELECT AVG(m.ph) FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3")
    int getPhAvg(Integer aquariumdId,Timestamp from, Timestamp to);

    @Query("SELECT AVG(m.temperature) FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3")
    Double getThermoAvg(Integer aquariumdId,Timestamp from, Timestamp to);

    @Query("SELECT AVG(m.orp) FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3")
    int getOrpAvg(Integer aquariumdId,Timestamp from, Timestamp to);

}
