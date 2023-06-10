package com.llama.headlessCMS.service;

import com.llama.headlessCMS.dto.ContentCreateRequestDTO;
import com.llama.headlessCMS.dto.ContentUpdateRequestDTO;
import com.llama.headlessCMS.model.Content;
import com.llama.headlessCMS.repository.ContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

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

    public Content updateContent(String id, ContentUpdateRequestDTO newContentDTO) {
        Content oldContent = contentRepository.findById(id).orElseThrow(() -> new RuntimeException("Content not found for this id :: " + id));

        if (newContentDTO.getType() != null) {
            oldContent.setType(newContentDTO.getType());
        }

        if (newContentDTO.getTitle() != null) {
            oldContent.setTitle(newContentDTO.getTitle());
        }

        if (newContentDTO.getData() != null) {
            oldContent.setData(newContentDTO.getData());
        }

        if (newContentDTO.getAuthor() != null) {
            oldContent.setAuthor(newContentDTO.getAuthor());
        }

        if (newContentDTO.getAltText() != null) {
            oldContent.setAltText(newContentDTO.getAltText());
        }

        if (newContentDTO.getStatus() != null) {
            oldContent.setStatus(newContentDTO.getStatus());
        }

        return contentRepository.save(oldContent);
    }

    public void deleteContent(String id) {
        contentRepository.deleteById(id);
    }
}
