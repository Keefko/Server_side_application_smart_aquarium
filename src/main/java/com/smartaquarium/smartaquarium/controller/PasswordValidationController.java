package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.User;
import com.smartaquarium.smartaquarium.repository.UserRepository;
import com.smartaquarium.smartaquarium.security.BcryptGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validation")
public class PasswordValidationController {

    private UserRepository userRepository;

    @Autowired
    public PasswordValidationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{login}/{password}")
    public Boolean validation(@PathVariable String login, @PathVariable String password ){
        BcryptGenerator bcryptGenerator = new BcryptGenerator();
        User user = userRepository.getUserByLogin(login);
        if(bcryptGenerator.isPasswordMatch(password,user.getPassword())){
            return true;
        }
        return false;
    }
}
