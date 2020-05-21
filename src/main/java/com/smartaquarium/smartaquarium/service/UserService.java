package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    List<User> getUsers();
    User get(int id);
    Integer add(User user);
    void deleteById(int id);
    User getUserByLogin(String login);
    User getUserByEmail(String email);
}
