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
        return new ResponseEntity<>("Spojenie senzorov s daným id" +id + " sa nenašlo" , HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Connection connection)
    {
        Connection con = connectionService.getByAquariumId(connection.getAquariumId());
        if(con == null) {
            connectionService.add(connection);
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }
        return new ResponseEntity<>("Spojenie senzorov na dáne akvárium uz existuje", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity updateConnection (@RequestBody Connection connection){
        Connection connection1 = connectionService.getByAquariumId(connection.getAquariumId());
        if(connection1 != null) {
            connectionService.add(connection);
            return new ResponseEntity<>(connection, HttpStatus.OK);
        }
        return new ResponseEntity<>("Spojenie s akávriom neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        Connection connection = connectionService.get(id);
        if(connection != null) {
            connectionService.deleteById(id);
            return new ResponseEntity<>("Spojenie bolo zmazané",HttpStatus.OK);
        }
        return new ResponseEntity<>("Spojenie s daným id neexistuje", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/aquarium/{id}")
    public ResponseEntity deleteByAquariumId(@PathVariable Integer id){
        Connection connection = connectionService.getByAquariumId(id);
        if(connection != null){
            connectionService.deleteByAquariumId(id);
            return new ResponseEntity<>("Spojenie bolo zmazané",HttpStatus.OK);
        }
        return new ResponseEntity<>("Spojenie s daným akváriom neexistuje", HttpStatus.NOT_FOUND);
    }
}
