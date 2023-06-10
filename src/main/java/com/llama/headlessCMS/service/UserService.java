package com.llama.headlessCMS.service;

import com.llama.headlessCMS.model.User;
import com.llama.headlessCMS.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.set_id(new ObjectId().toHexString());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserByUserId(String userId) {
        return userRepository.findUserByUserId(userId);
    }

    public List<User> getUserByRole(String role) {
        return userRepository.findByRole(role);
    }

    public String deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
        return "User: " + userId + " deleted successfully.";
    }
}
