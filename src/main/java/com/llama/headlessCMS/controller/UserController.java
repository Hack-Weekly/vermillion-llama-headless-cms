package com.llama.headlessCMS.controller;

import com.llama.headlessCMS.dto.UserCreateRequestDTO;
import com.llama.headlessCMS.model.Role;
import com.llama.headlessCMS.model.User;
import com.llama.headlessCMS.service.UserService;
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
    public User createUser(@RequestBody UserCreateRequestDTO requestDTO) {
        return userService.createUser(requestDTO);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{username}")
    public List<User> getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/role/{role}")
    public List<User> getUserByRole(@PathVariable Role role) {
        return userService.getUserByRole(role);
    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }
}
