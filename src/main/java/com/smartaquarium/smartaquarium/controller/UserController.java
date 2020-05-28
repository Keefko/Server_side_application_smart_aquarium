package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.User;
import com.smartaquarium.smartaquarium.service.AquariumService;
import com.smartaquarium.smartaquarium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    private UserService userService;
    private AquariumService aquariumService;

    @Autowired
    public UserController(UserService userService, AquariumService aquariumService) {
        this.userService = userService;
        this.aquariumService = aquariumService;
    }

    @GetMapping("/{id}")
    public ResponseEntity findUserById(@PathVariable int id){
        User user = userService.get(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>("Užívateľ s id" + id + "neexistuje", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user){
        User user1 = userService.getUserByLogin(user.getLogin());
        User user2 = userService.getUserByEmail(user.getEmail());
        if(user1 != null){
            return new ResponseEntity<>("Užívateľ s prihlásovacím menom " + user.getLogin() + " už existuje", HttpStatus.BAD_REQUEST);
        }

        if(user2 != null){
            return new ResponseEntity<>("Užívateľ s daným emailom " + user.getEmail() + " už existuje", HttpStatus.BAD_REQUEST);
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

        if(user != null){


            List<Aquarium> aquariums = aquariumService.getAllUsersAquariums(id);
            for(Aquarium aquarium : aquariums){
                aquarium.setUserId(0);
                aquariumService.add(aquarium);
            }
            //userService.deleteById(id);
            return new ResponseEntity<>(aquariums, HttpStatus.OK);
            //return new ResponseEntity<>(id + ": Užívateľ bol zmazaný", HttpStatus.OK);

        }

        return new ResponseEntity<>("Užívateľ s id" + id + "neexistuje", HttpStatus.NOT_FOUND);
    }
}
