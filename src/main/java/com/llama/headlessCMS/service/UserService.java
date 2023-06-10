package com.llama.headlessCMS.service;

import com.llama.headlessCMS.dto.UserCreateRequestDTO;
import com.llama.headlessCMS.model.Role;
import com.llama.headlessCMS.model.User;
import com.llama.headlessCMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateRequestDTO userDTO) {
        User user = userDTO.toUser();
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<User> getUserByRole(Role role) {
        return userRepository.findByRole(role);
    }

    public String deleteUser(String username) {
        userRepository.deleteByUsername(username);
        return "User: " + username + " deleted successfully.";
    }
}
