package com.llama.headlessCMS.repository;

import com.llama.headlessCMS.model.Role;
import com.llama.headlessCMS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{userId:  ?0} ")
    List<User> findUserByUsername(String username);

    @Query("{role:  ?0} ")
    List<User> findByRole(Role role);

    void deleteByUsername(String username);
}
