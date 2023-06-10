package com.llama.headlessCMS.repository;

import com.llama.headlessCMS.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContentRepository extends MongoRepository<Content, String> {
    List<Content> findByAuthor(String author);

    List<Content> findByTitle(String title);
}
