package com.llama.headlessCMS.controller;


import com.llama.headlessCMS.dto.ContentCreateRequestDTO;
import com.llama.headlessCMS.dto.ContentUpdateRequestDTO;
import com.llama.headlessCMS.model.Content;
import com.llama.headlessCMS.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cms/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Content createContent(@RequestBody ContentCreateRequestDTO requestDTO) {
        return contentService.createContent(requestDTO);
    }

    @GetMapping
    public List<Content> getAllContent() {
        return contentService.getAllContent();
    }

    @GetMapping("/data/{id}")
    public Content getContentById(@PathVariable String id) {
        return contentService.getContentById(id);
    }

    @GetMapping("/author/{author}")
    public List<Content> getContentByAuthor(@PathVariable String author) {
        return contentService.getContentByAuthor(author);
    }

    @GetMapping("/title/{title}")
    public List<Content> getContentByTitle(@PathVariable String title) {
        return contentService.getContentByTitle(title);
    }

    @PutMapping
    public Content updateContent(@RequestBody ContentUpdateRequestDTO requestDTO) {
        return contentService.updateContent(requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteContent(@PathVariable String id) {
        return contentService.deleteContent(id);
    }


}
