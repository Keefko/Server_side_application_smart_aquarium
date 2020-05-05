package com.smartaquarium.smartaquarium;

import com.smartaquarium.smartaquarium.entity.*;
import com.smartaquarium.smartaquarium.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBtest {

    private final String insertAquarium = "INSERT INTO aquarium(aquarium_id, name, user_id,warning) values(?,?,?,?)";
    private final String insertUser = "INSERT INTO user(login,email,password) values(?,?,?)";
    private final String insertSettings = "INSERT INTO aquarium_settings(name,ph,temperature,aquarium_id,orp) values(?,?,?,?,?)";
    private final String insertComponent = "INSERT INTO component(aquarium_id, name, period_allowed, period) values(?,?,?,?)";
    private final String insertMeasurament = "INSERT INTO measurament(aquarium_id, ph, orp, temperature, create_time) values(?,?,?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createUser(){
        User user = new User("Dany","ahoj","kok@gmail.com");
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                return preparedStatement;
            }
        });
    }

    @Test
    public void dbTest(){
        Aquarium aquarium = new Aquarium();
        aquarium.setId(15425);
        aquarium.setName("Aquarium 1");
        aquarium.setUserId(1);
        aquarium.setWarning(false);
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(insertAquarium);
                preparedStatement.setInt(1, aquarium.getId());
                preparedStatement.setString(2, aquarium.getName());
                preparedStatement.setInt(3, aquarium.getUserId());
                preparedStatement.setBoolean(4,aquarium.getWarning());
                return preparedStatement;
            }
        });

    }

    @Test
    public void createComponent(){
        Component component = new Component();
        component.setAquariumId(15425);
        component.setName("teplomer");
        component.setPeriodAllowed(true);
        component.setPeriod(Timestamp.from(Instant.now()));

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(insertComponent);
                preparedStatement.setInt(1, component.getAquariumId());
                preparedStatement.setString(2, component.getName());
                preparedStatement.setBoolean(3, component.getPeriodAllowed());
                preparedStatement.setTimestamp(4, component.getPeriod());
                return preparedStatement;
            }
        });
    }

    @Test
    public void createMeasurament(){
        Measurament measurament = new Measurament();
        measurament.setAquariumId(15425);
        measurament.setOrp(6);
        measurament.setPh(7);
        measurament.setTemperature(28.5);
        measurament.setCreateTime(Timestamp.from(Instant.now()));

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(insertMeasurament);
                preparedStatement.setInt(1, measurament.getAquariumId());
                preparedStatement.setInt(2, measurament.getPh());
                preparedStatement.setInt(3, measurament.getOrp());
                preparedStatement.setDouble(4, measurament.getTemperature());
                preparedStatement.setTimestamp(5, measurament.getCreateTime());
                return preparedStatement;
            }
        });
    }

   @Test
    public void createSettings(){
        AquariumSettings aquariumSettings = new AquariumSettings(25,15,27.5,15425,"Aquarium sladkovodne");
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(insertSettings);
                preparedStatement.setString(1, aquariumSettings.getName());
                preparedStatement.setInt(2, aquariumSettings.getPh());
                preparedStatement.setDouble(3, aquariumSettings.getTemperature());
                preparedStatement.setInt(4,aquariumSettings.getAquariumId());
                preparedStatement.setInt(5,aquariumSettings.getOrp());
                return preparedStatement;
            }
        });
    }

}
