package com.llama.headlessCMS.service;

import com.llama.headlessCMS.dto.ContentCreateRequestDTO;
import com.llama.headlessCMS.dto.ContentUpdateRequestDTO;
import com.llama.headlessCMS.model.Content;
import com.llama.headlessCMS.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content createContent(ContentCreateRequestDTO content) {
        Content newContent = content.toContent();
        return contentRepository.save(newContent);
    }

    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    public Content getContentById(String id) {
        return contentRepository.findById(id).orElseThrow(() -> new RuntimeException("Content not found for this id :: " + id));
    }

    public List<Content> getContentByAuthor(String author) {
        return contentRepository.findByAuthor(author);
    }

    public List<Content> getContentByTitle(String title) {
        return contentRepository.findByTitle(title);
    }

    public Content updateContent(ContentUpdateRequestDTO newContentDTO) {
        Content oldContent = contentRepository.findById(newContentDTO.getId()).orElseThrow(() -> new RuntimeException("Content not found for this id :: " + newContentDTO.getId()));

        oldContent.setType(newContentDTO.getType());
        oldContent.setTitle(newContentDTO.getTitle());
        oldContent.setData(newContentDTO.getData());
        oldContent.setAuthor(newContentDTO.getAuthor());
        oldContent.setAltText(newContentDTO.getAltText());
        oldContent.setStatus(newContentDTO.getStatus());
        return contentRepository.save(oldContent);
    }

    public String deleteContent(String id) {
        contentRepository.deleteById(id);
        return "Content with ID: " + id + " deleted successfully.";
    }

}
