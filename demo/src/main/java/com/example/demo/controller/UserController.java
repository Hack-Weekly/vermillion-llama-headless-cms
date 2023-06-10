package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cms/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public List<User> getUser(@PathVariable String userId) {
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/role/{role}")
    public List<User> getUserByRole(@PathVariable String role) {
        return userService.getUserByRole(role);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
