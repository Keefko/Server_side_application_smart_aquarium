package com.smartaquarium.smartaquarium.service;

import com.smartaquarium.smartaquarium.entity.Connection;
import org.springframework.stereotype.Service;

@Service
public interface ConnectionService {

    Connection getByAquariumId(Integer aquariumId);
    Connection get(Integer id);
    void add(Connection connection);
    void deleteById(Integer id);
    void deleteByAquariumId(Integer aquariumId);

}
