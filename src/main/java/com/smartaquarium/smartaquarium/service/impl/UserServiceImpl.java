package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.User;
import com.smartaquarium.smartaquarium.repository.UserRepository;
import com.smartaquarium.smartaquarium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User get(int id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        } else {
            throw new RuntimeException("Nenašiel sa uživateľ s id" + id);
        }
        return user;
    }

    @Override
    @Transactional
    public Integer add(User user) {
        User usr = userRepository.getUserByLogin(user.getLogin());
        if(usr != null){
            throw new RuntimeException("Užívateľ s existujúcim" + user.getLogin() + "už existuje");
        }
        User user1 = userRepository.getUserByEmail(user.getEmail());
        if(user1 != null){
            throw new RuntimeException("Užívateľ s existujúcim" + user.getEmail() + "už existuje");
        }

        return userRepository.save(user).getId();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
