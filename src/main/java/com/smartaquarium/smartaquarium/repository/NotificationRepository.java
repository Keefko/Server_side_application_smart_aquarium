package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query("SELECT n FROM Notification n WHERE n.aquariumId = ?1 AND n.property = ?2 AND n.visible = true")
    Notification getAquariumNotificationByProperty(Integer aquariumId, String property);

    @Query("SELECT n FROM Notification n WHERE n.aquariumId = ?1 AND n.visible = true")
    List<Notification> getAquariumNotifications(Integer aquariumId);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM heroku_651b634aa63afee.notification JOIN heroku_651b634aa63afee.aquarium ON user_id = ?1 where visible = 1 ", nativeQuery = true)
    List<Object[]> getUserNotifications(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Notification n WHERE n.aquariumId = ?1")
    void deleteByAquariumId(Integer aquariumId);
}
