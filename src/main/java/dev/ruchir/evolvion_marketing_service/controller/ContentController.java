package dev.ruchir.evolvion_marketing_service.controller;

import dev.ruchir.evolvion_marketing_service.dto.ContentDTO;
import dev.ruchir.evolvion_marketing_service.model.Enums.ContentType;
import dev.ruchir.evolvion_marketing_service.services.Interfaces.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping
    public ResponseEntity<ContentDTO> createContent(@RequestBody ContentDTO contentDTO) {
        ContentDTO createdContent = contentService.createContent(contentDTO);
        return new ResponseEntity<>(createdContent, HttpStatus.CREATED);
    }

    @PutMapping("/{contentId}")
    public ResponseEntity<ContentDTO> updateContent(@PathVariable Long contentId, @RequestBody ContentDTO contentDTO) {
        ContentDTO updatedContent = contentService.updateContent(contentId, contentDTO);
        return ResponseEntity.ok(updatedContent);
    }

    @DeleteMapping("/{contentId}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long contentId) {
        contentService.deleteContent(contentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ContentDTO> getContentById(@PathVariable Long contentId) {
        ContentDTO content = contentService.getContentById(contentId);
        return ResponseEntity.ok(content);
    }

    @GetMapping
    public ResponseEntity<List<ContentDTO>> getAllContent() {
        List<ContentDTO> contents = contentService.getAllContent();
        return ResponseEntity.ok(contents);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<ContentDTO> getContentByTitle(@PathVariable String title) {
        ContentDTO content = contentService.getContentByTitle(title);
        return ResponseEntity.ok(content);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<ContentDTO>> getContentByType(@PathVariable ContentType type) {
        List<ContentDTO> contents = contentService.getContentByType(type);
        return ResponseEntity.ok(contents);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContentDTO>> searchContentByDescription(@RequestParam String keyword) {
        List<ContentDTO> contents = contentService.searchContentByDescription(keyword);
        return ResponseEntity.ok(contents);
    }

    @GetMapping("/created-after")
    public ResponseEntity<List<ContentDTO>> getContentCreatedAfter(@RequestParam Date date) {
        List<ContentDTO> contents = contentService.getContentCreatedAfter(date);
        return ResponseEntity.ok(contents);
    }

    @GetMapping("/url")
    public ResponseEntity<ContentDTO> getContentByUrl(@RequestParam String url) {
        ContentDTO content = contentService.getContentByUrl(url);
        return ResponseEntity.ok(content);
    }
}
