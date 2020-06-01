package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.MqttBroker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MqttBrokerRepository extends JpaRepository<MqttBroker, Integer> {

    @Query("SELECT m FROM MqttBroker m WHERE m.aquariumId = ?1")
    MqttBroker getBrokerDataByAquariumId(Integer aquariumId);

    @Transactional
    @Modifying
    @Query("DELETE FROM MqttBroker m WHERE m.aquariumId = ?1")
    void deleteByAquariumId(Integer aquariumId);
}
