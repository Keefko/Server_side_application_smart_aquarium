package com.bachelor.smartaquarium;


import com.bachelor.smartaquarium.entity.Aquarium;
import com.bachelor.smartaquarium.entity.AquariumStatus;
import com.bachelor.smartaquarium.entity.AquariumType;
import com.bachelor.smartaquarium.entity.User;
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

    private final String insertAquarium = "INSERT INTO aquarium(user_id, name, create_time, update_time,type,status) values(?,?,?,?,?,?)";
    private final String insertUser = "INSERT INTO user(name,email,password, aquarium_id) values(?,?,?,?)";
    private final String getInsertAquariumStatus = "INSERT INTO aquarium_status(status) values(?)";
    private final String InsertAquariumType = "INSERT INTO aquarium_type(type) values(?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createUser(){
        User user = new User();
        user.setName("Dany");
        user.setEmail("kok@gmail.com");
        user.setPassword("ahoj");
        user.setAquariumID(4);
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setInt(4,user.getAquariumID());
                return preparedStatement;
            }
        });
    }

    @Test
    public  void createStatus(){
        AquariumStatus aquariumStatus = new AquariumStatus();
        aquariumStatus.setStatus("running");
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(getInsertAquariumStatus);
                preparedStatement.setString(1, aquariumStatus.getStatus());
                return preparedStatement;
            }
        });
    }

    @Test
    public void createType(){
        AquariumType aquariumType = new AquariumType();
        aquariumType.setType("sladkovodné");
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(InsertAquariumType);
                preparedStatement.setString(1, aquariumType.getType());
                return preparedStatement;
            }
        });
    }


    @Test
    public void dbTest(){
        Aquarium aquarium = new Aquarium();
        aquarium.setName("arne");
        aquarium.setStatus(1);
        aquarium.setType(1);
        aquarium.setCreateTime(Timestamp.from(Instant.now()));
        aquarium.setUpdateTime(Timestamp.from(Instant.now()));
        aquarium.setUserId(0);


        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(insertAquarium);

                preparedStatement.setInt(1, aquarium.getUserId());
                preparedStatement.setString(2, aquarium.getName());
                preparedStatement.setTimestamp(3, aquarium.getCreateTime());
                preparedStatement.setTimestamp(4,aquarium.getUpdateTime());
                preparedStatement.setInt(5,aquarium.getType());
                preparedStatement.setInt(6, aquarium.getStatus());
                return preparedStatement;
            }
        });

    }
}
