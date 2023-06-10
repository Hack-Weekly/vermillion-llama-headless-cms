package com.llama.headlessCMS.controller;


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
    public Content createContent(@RequestBody Content content) {
        return contentService.createContent(content);
    }

    @GetMapping
    public List<Content> getAllContent() {
        return contentService.getAllContent();
    }

    @GetMapping("/data/{_id}")
    public Content getContentById(@PathVariable String _id) {
        return contentService.getContentById(_id);
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
    public Content updateContent(@RequestBody Content content) {
        return contentService.updateContent(content);
    }

    @DeleteMapping("/{_id}")
    public String deleteContent(@PathVariable String _id) {
        return contentService.deleteContent(_id);
    }


}
