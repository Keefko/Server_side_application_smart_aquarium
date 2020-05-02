package com.smartaquarium.smartaquarium.repository;

import com.smartaquarium.smartaquarium.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,Integer> {
}
