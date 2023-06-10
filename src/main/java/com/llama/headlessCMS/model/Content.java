package com.llama.headlessCMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "contents")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Content {
    @Id
    private String id;
    private String type;
    private String title;
    private String data;
    private String author;
    private String altText;
    private Status status;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
}
