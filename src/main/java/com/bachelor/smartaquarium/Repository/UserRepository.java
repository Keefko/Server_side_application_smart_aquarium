package com.bachelor.smartaquarium.Repository;

import com.bachelor.smartaquarium.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
