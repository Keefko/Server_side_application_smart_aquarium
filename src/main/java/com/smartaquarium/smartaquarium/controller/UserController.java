package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.User;
import com.smartaquarium.smartaquarium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id){
        User user = userService.get(id);
        if(user == null){
            throw new RuntimeException("Užívateľ s id" + id + "neexistuje");
        }
        return user;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.add(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        userService.add(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        User user = userService.get(id);

        if(user == null){
            throw new RuntimeException("Užívateľ s id" + id + "neexistuje");
        }

        userService.deleteById(id);
        return (id + ": Užívateľ bol zmazaný");
    }
}
