package com.llama.headlessCMS.service;

import com.llama.headlessCMS.dto.UserCreateRequestDTO;
import com.llama.headlessCMS.dto.UserUpdateRequestDTO;
import com.llama.headlessCMS.model.Role;
import com.llama.headlessCMS.model.User;
import com.llama.headlessCMS.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public User updateUser(String id, UserUpdateRequestDTO newUserUpdateDTO) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found for this id :: " + id));

        if (newUserUpdateDTO.getUsername() != null) {
            oldUser.setUsername(newUserUpdateDTO.getUsername());
        }

        if (newUserUpdateDTO.getPassword() != null) {
            oldUser.setPassword(newUserUpdateDTO.getPassword());
        }

        if (newUserUpdateDTO.getRole() != null) {
            oldUser.setRole(newUserUpdateDTO.getRole());
        }

        return userRepository.save(oldUser);
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }
}
