package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.User;
import com.smartaquarium.smartaquarium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity findUserById(@PathVariable int id){
        User user = userService.get(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        HashMap<String, String> response = new HashMap<>();
        response.put("response","Užívateľ s id" + id + "neexistuje");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user){
        User user1 = userService.getUserByLogin(user.getLogin());
        User user2 = userService.getUserByEmail(user.getEmail());
        HashMap<String, String> response = new HashMap<>();
        if(user1 != null){
            response.put("response","Užívateľ s prihlásovacím menom " + user.getLogin() + " už existuje");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        if(user2 != null){
            response.put("response","Užívateľ s daným emailom " + user.getEmail() + " už existuje");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        userService.add(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user){
        User user1 = userService.get(user.getId());
        if(user1 != null){
            userService.add(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }

        return new ResponseEntity<>("Užívateľ neexistuje",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        User user = userService.get(id);

        if(user == null){
            return new ResponseEntity<>("Užívateľ s id" + id + "neexistuje", HttpStatus.NOT_FOUND);
        }

        userService.deleteById(id);
        return new ResponseEntity<>(id + ": Užívateľ bol zmazaný", HttpStatus.OK);
    }
}
