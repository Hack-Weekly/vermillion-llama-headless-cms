package com.llama.repositories;

import com.llama.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
    // Additional query methods can be defined here
}
