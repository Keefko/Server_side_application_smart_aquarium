package com.bachelor.smartaquarium;


import com.bachelor.smartaquarium.entity.User;
import com.bachelor.smartaquarium.service.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void user(){
        User user = new User("Dany","kok@gmail.com","ahoj",4);
        userService.add(user);
    }
}
