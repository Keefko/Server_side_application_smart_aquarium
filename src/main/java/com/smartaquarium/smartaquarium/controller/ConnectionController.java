package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Connection;
import com.smartaquarium.smartaquarium.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("connection")
public class ConnectionController {

    private ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @GetMapping("/aquarium/{id}")
    public Connection getByAquariumId(@PathVariable Integer id){
        return connectionService.getByAquariumId(id);
    }

    @GetMapping("/{id}")
    public Connection get(@PathVariable Integer id){
        Connection connection = connectionService.get(id);
        if(connection == null){
            throw new RuntimeException("Pripojenie senzorov s id" + id + "sa nenašlo");
        }
        return connection;
    }

    @PostMapping("/add")
    public void add(@RequestBody Connection connection)
    {
        Connection con = connectionService.getByAquariumId(connection.getAquariumId());
        if(con == null) {
            connectionService.add(connection);
        } else {
            throw new RuntimeException("Konekcia na akvárium s id" +  connection.getAquariumId() + "už existuje");
        }
    }

    @PutMapping
    public Connection updateConnection (@RequestBody Connection connection){
        connectionService.add(connection);
        return connection;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        connectionService.deleteById(id);
    }

    @DeleteMapping("/aquarium/{id}")
    public void deleteByAquariumId(Integer id){
        connectionService.deleteByAquariumId(id);
    }
}
