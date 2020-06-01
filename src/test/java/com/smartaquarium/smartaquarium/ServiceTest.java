package com.smartaquarium.smartaquarium;


import com.smartaquarium.smartaquarium.entity.Aquarium;
import com.smartaquarium.smartaquarium.entity.Measurament;
import com.smartaquarium.smartaquarium.entity.User;


import com.smartaquarium.smartaquarium.service.AquariumService;
import com.smartaquarium.smartaquarium.service.MeasuramentService;
import com.smartaquarium.smartaquarium.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private AquariumService aquariumService;

    @Autowired
    private MeasuramentService measuramentService;

    @Test
    public void user(){
        User user = new User();
        user.setLogin("Arne");
        user.setEmail("arne@gmail.com");
        user.setPassword("smallpenis");
        Integer id = userService.add(user);

        User userFind = userService.get(3);
        userService.deleteById(userFind.getId());
    }

    @Test
    public void aquarium(){
        Aquarium aquarium = new Aquarium(18645,4,"Akvárium 3");
        aquariumService.add(aquarium);
        Aquarium aquarium2 = new Aquarium(18845,4,"Akvárium 4");
        aquariumService.add(aquarium2);

        Aquarium aquariumFind = aquariumService.get(15425);
        System.out.println(aquariumFind);

        List<Aquarium> aquariums = aquariumService.getAllUsersAquariums(4);

        for(Aquarium aquarium1 : aquariums){
            System.out.println(aquarium1);
        }
    }

    @Test
    public void measurament(){
        Measurament measurament = new Measurament(18845, 20, 15, 27.5, Timestamp.from(Instant.now()));
        measuramentService.add(measurament);
        List<Measurament> measuraments = measuramentService.getAllMeasuramentByAquariumId(18845);

        System.out.println(measuraments);
    }
}
