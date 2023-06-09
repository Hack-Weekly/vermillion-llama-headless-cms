package com.example.demo.repository;

import com.example.demo.model.Content;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ContentRepository extends MongoRepository<Content, String> {

    @Query("{author:  ?0} ")
    List<Content> findByAuthor(String author);

    @Query("{title:  ?0} ")
    List<Content> findByTitle(String title);
}
