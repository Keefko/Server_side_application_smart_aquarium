package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u from User u WHERE u.login = ?1 ")
    User getUserByLogin(String login);

    @Query("SELECT u from User u WHERE u.email = ?1 ")
    User getUserByEmail(String email);
}
