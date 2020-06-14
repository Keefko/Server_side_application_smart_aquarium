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

    @Query("SELECT m FROM Measurament m WHERE m.aquariumId = ?1 ORDER BY m.createTime DESC")
    List<Measurament> getLastMeasurament(Integer aquariumId);

    @Query("SELECT AVG(m.ph), m.createTime FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3 group by date(create_time), hour(create_time)")
    List<Object[]> getPhAvg(Integer aquariumdId, Timestamp from, Timestamp to);

    @Query("SELECT AVG(m.ph), m.createTime FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3 group by date(create_time)")
    List<Object[]> getPhAvgD(Integer aquariumdId, Timestamp from, Timestamp to);

    @Query("SELECT AVG(m.temperature), m.createTime FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3 group by date(create_time), hour(create_time)")
    List<Object[]> getThermoAvg(Integer aquariumdId,Timestamp from, Timestamp to);

    @Query("SELECT AVG(m.temperature), m.createTime FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3 group by date(create_time)")
    List<Object[]> getThermoAvgD(Integer aquariumdId,Timestamp from, Timestamp to);

    @Query("SELECT AVG(m.orp), m.createTime FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3 group by date(create_time), hour(create_time)")
    List<Object[]> getOrpAvg(Integer aquariumdId,Timestamp from, Timestamp to);

    @Query("SELECT AVG(m.orp), m.createTime FROM Measurament m WHERE m.aquariumId = ?1 AND m.createTime BETWEEN ?2 AND ?3 group by date(create_time)")
    List<Object[]> getOrpAvgD(Integer aquariumdId,Timestamp from, Timestamp to);

    @Modifying
    @Transactional
    @Query(value = "SELECT CONCAT(WEEK(m.createTime), m.ph) as con FROM Measurament m WHERE m.aquarium_id = ?1 AND m.createTime BETWEEN ?2 AND ?3 GROUP BY WEEK(m.createTime)", nativeQuery = true)
    List<Object[]> getThermoAvgW(Integer aquariumdId,Timestamp from, Timestamp to);

    @Modifying
    @Transactional
    @Query(value = "SELECT CONCAT(WEEK(m.createTime) - WEEK(DATE_SUB(m.createTime, INTERVAL DAYOFMONTH(m.createTime) - 1 DAY ))+1,MONTH(m.createTime), YEAR(m.createTime)), ROUND(AVG(m.orp),2) FROM Measurament m WHERE m.aquarium_id = ?1 AND m.createTime BETWEEN ?2 AND ?3 GROUP BY WEEK(m.createTime)",nativeQuery = true)
    List<Object[]> getOrpAvgW(Integer aquariumdId,Timestamp from, Timestamp to);

    @Modifying
    @Transactional
    @Query(value = "SELECT CONCAT(WEEK(m.createTime) - WEEK(DATE_SUB(m.createTime, INTERVAL DAYOFMONTH(m.createTime) - 1 DAY ))+1,MONTH(m.createTime),YEAR(m.createTime)), ROUND(AVG(m.ph),2) FROM Measurament m WHERE m.aquarium_id = ?1 AND m.createTime BETWEEN ?2 AND ?3 GROUP BY WEEK(m.createTime)", nativeQuery = true)
    List<Object[]> getPhAvgW(Integer aquariumdId, Timestamp from, Timestamp to);


}
