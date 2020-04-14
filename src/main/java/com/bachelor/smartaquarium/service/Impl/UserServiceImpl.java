package com.bachelor.smartaquarium.service.Impl;

import com.bachelor.smartaquarium.Repository.UserRepository;
import com.bachelor.smartaquarium.entity.User;
import com.bachelor.smartaquarium.service.api.Request.UpdateUserRequest;
import com.bachelor.smartaquarium.service.api.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User get(long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return  user.get();
        } else{
            return null;
        }
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(long id, UpdateUserRequest request) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            User newUser = user.get();
            newUser.setPassword(request.getPassword());
            newUser.setEmail(request.getEmail());
            return add(newUser);
        } else {
            return add(user.get());
        }
    }
}
