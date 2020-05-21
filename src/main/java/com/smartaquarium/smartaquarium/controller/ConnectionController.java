package com.smartaquarium.smartaquarium.controller;


import com.smartaquarium.smartaquarium.entity.Connection;
import com.smartaquarium.smartaquarium.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity  getByAquariumId(@PathVariable Integer id){
        Connection connection = connectionService.getByAquariumId(id);
        if(connection != null){
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }
        return new ResponseEntity<>("Akvárium s daným id" +id + " neexistuje" , HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id){
        Connection connection = connectionService.get(id);
        if(connection != null){
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }
        return new ResponseEntity<>("Pripojenie senzorov s daným id" +id + " sa nenašlo" , HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Connection connection)
    {
        Connection con = connectionService.getByAquariumId(connection.getAquariumId());
        if(con == null) {
            connectionService.add(connection);
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }
        return new ResponseEntity<>("Pripojenie senzorov na dáne akvárium uz existuje", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity updateConnection (@RequestBody Connection connection){
        Connection connection1 = connectionService.getByAquariumId(connection.getAquariumId());
        if(connection1 != null) {
            connectionService.add(connection);
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }
        return new ResponseEntity<>("Pripojenie na akávrium neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        connectionService.deleteById(id);
    }

    @DeleteMapping("/aquarium/{id}")
    public void deleteByAquariumId(@PathVariable Integer id){
        connectionService.deleteByAquariumId(id);
    }
}
