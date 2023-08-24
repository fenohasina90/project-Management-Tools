package com.example.projectmanagementtools.controller;

import com.example.projectmanagementtools.entity.User;
import com.example.projectmanagementtools.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/allUser")
    public List<User> getAllUser(){
        return this.userService.findAllUser();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return this.userService.findUserById(id);
    }

    @PostMapping("/addUser")
    public User insertUser(@RequestBody User toInsert){
        return this.userService.insert(toInsert);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        if (updatedUser.getId() != id) {
            throw new IllegalArgumentException("The ID provided in the request body does not match the ID in the path.");
        }
        return this.userService.updateUser(updatedUser);
    }

}
