package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{userId:  ?0} ")
    List<User> findUserByUserId(String userId);

    @Query("{role:  ?0} ")
    List<User> findByRole(String role);

    void deleteByUserId(String userId);
}
