package com.llama.headlessCMS.dto;

import com.llama.headlessCMS.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentUpdateRequestDTO {
    private String id;
    private String type;
    private String title;
    private String data;
    private String author;
    private String altText;
    private Status status;
}
