package com.llama.headlessCMS.repository;

import com.llama.headlessCMS.model.Role;
import com.llama.headlessCMS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findUserByUsername(String username);

    List<User> findByRole(Role role);

    void deleteByUsername(String username);
}
