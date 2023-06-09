package com.example.demo.service;

import com.example.demo.model.Content;
import com.example.demo.repository.ContentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content createContent(Content content) {
        content.set_id(new ObjectId().toHexString());
        return contentRepository.save(content);
    }

    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    public Content getContentById(String _id) {
        return contentRepository.findById(_id).get();
    }

    public List<Content> getContentByAuthor(String author) {
        return contentRepository.findByAuthor(author);
    }

    public List<Content> getContentByTitle(String title) {
        return contentRepository.findByTitle(title);
    }

    public Content updateContent(Content newContent) {
        Content oldContent = contentRepository.findById(newContent.get_id()).get();
        oldContent.setAltText(newContent.getAltText());
        oldContent.setData(newContent.getData());
        oldContent.setTitle(newContent.getTitle());
        oldContent.setUpdateTime(newContent.getUpdateTime());
        return contentRepository.save(newContent);
    }

    public String deleteContent(String _id) {
        contentRepository.deleteById(_id);
        return "Content with ID: " + _id + " deleted successfully.";
    }

}
