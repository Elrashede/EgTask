package com.example.task.controller;

import com.example.task.model.User;
import com.example.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User>getAllUsers(){
        return ResponseEntity.ok().body(userService.getAll()).getBody();
    }
    @GetMapping("/user")
    public ResponseEntity<Optional<User>> getUserByID(@RequestParam int id){
        return ResponseEntity.ok().body(userService.getUser(id));
    }
    @PostMapping("/add")
    public User saveUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveUser(user)).getBody();
    }
    @PutMapping("/update")
    public User updateUser(@RequestParam int id,@RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUser(id,user)).getBody();

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }


}
