package com.smartaquarium.smartaquarium.controller;

import com.smartaquarium.smartaquarium.entity.User;
import com.smartaquarium.smartaquarium.repository.UserRepository;
import com.smartaquarium.smartaquarium.security.BcryptGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;

@RestController
@RequestMapping("login")
public class LoginController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{login}/{password}")
    public ResponseEntity userLoggedIn(@PathVariable String login, @PathVariable String password ){
        //BcryptGenerator bcryptGenerator = new BcryptGenerator();
        HashMap<String,String> response = new HashMap<>();
        User user = userRepository.getUserByLogin(login);
        response.put("login",user.getLogin());
        response.put("userHeslo",passwordEncoder.encode(user.getPassword()));
        response.put("heslo",password);
        if(passwordEncoder.matches(user.getPassword(), password)){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
//        if(bcryptGenerator.isPasswordMatch(user.getPassword(),password)){
//
//        }
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
