package com.llama.headlessCMS.dto;

import com.llama.headlessCMS.model.Content;
import com.llama.headlessCMS.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentCreateRequestDTO {
    private String type;
    private String title;
    private String data;
    private String author;
    private String altText;
    private Status status;

    public Content toContent() {
        Content content = new Content();
        content.setType(this.type);
        content.setTitle(this.title);
        content.setData(this.data);
        content.setAuthor(this.author);
        content.setAltText(this.altText);
        content.setStatus(this.status);
        return content;
    }
}
