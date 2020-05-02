package com.smartaquarium.smartaquarium.service.impl;

import com.smartaquarium.smartaquarium.entity.Connection;
import com.smartaquarium.smartaquarium.repository.ConnectionRepository;
import com.smartaquarium.smartaquarium.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ConnectionServiceImpl implements ConnectionService {

    private ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionServiceImpl(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @Override
    public Connection getByAquariumId(Integer aquariumId) {
        return connectionRepository.getByAquariumId(aquariumId);
    }

    @Override
    public Connection get(Integer id) {
        Optional<Connection> optional = connectionRepository.findById(id);
        Connection connection = null;
        if(optional.isPresent()){
            connection = optional.get();
        } else{
            throw new RuntimeException("Pripojenie senzorov s id" + id + "sa nenašlo");
        }
        return connection;
    }

    @Override
    public void add(Connection connection) {
        connectionRepository.save(connection);
    }

    @Override
    public void deleteById(Integer id) {
        connectionRepository.deleteById(id);
    }

    @Override
    public void deleteByAquariumId(Integer aquariumId) {
        connectionRepository.deleteByAquariumId(aquariumId);
    }
}
