package com.Dadhich.Chess.Controller;

import com.Dadhich.Chess.Model.User;
import com.Dadhich.Chess.MongoConnection.MongoDBConnection;
import com.Dadhich.Chess.Service.UserService;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }








}
