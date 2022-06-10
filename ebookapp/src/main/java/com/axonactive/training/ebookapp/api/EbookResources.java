package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.EbookRequest;
import com.axonactive.training.ebookapp.entity.Ebook;
import com.axonactive.training.ebookapp.service.CategoryService;
import com.axonactive.training.ebookapp.service.EbookService;
import com.axonactive.training.ebookapp.service.LanguageService;
import com.axonactive.training.ebookapp.service.PublisherService;
import com.axonactive.training.ebookapp.service.dto.EbookDto;
import com.axonactive.training.ebookapp.service.mapper.EbookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(EbookResources.PATH)
public class EbookResources {

    public static final String PATH = "/api/ebooks";

    @Autowired
    EbookService ebookService;
    @Autowired
    LanguageService languageService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<EbookDto>> getAll() {
        List<Ebook> ebookList = ebookService.getAll();
        return ResponseEntity.ok(EbookMapper.INSTANCE.toDtos(ebookList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EbookDto> getEbookById(@PathVariable UUID id) throws ResourceNotFoundException {
        Ebook ebook = ebookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
        return ResponseEntity.ok().body(EbookMapper.INSTANCE.toDto(ebook));
    }

    @PostMapping
    public ResponseEntity<EbookDto> create(@RequestBody EbookRequest ebook) {
        Ebook createdEbook = ebookService.save(new Ebook(
                null, ebook.getTitle(), ebook.getDescription(), ebook.getPublishYear(),
                "path", LocalDateTime.now(),
                languageService.findById(ebook.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Language not found: " + ebook.getLanguageId())),
                publisherService.findById(ebook.getPublisherId()).orElseThrow(() -> new ResourceNotFoundException("Publisher not found: " + ebook.getPublisherId())),
                categoryService.findById(ebook.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found: " + ebook.getCategoryId()))));

        return ResponseEntity.created(URI.create(PATH + "/" + createdEbook.getId())).body(EbookMapper.INSTANCE.toDto(createdEbook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EbookDto> update(@PathVariable(value = "id") UUID id, @RequestBody EbookRequest ebookUpdate) throws ResourceNotFoundException {
        Ebook ebook = ebookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not found: " + id));
        ebook.setTitle(ebookUpdate.getTitle());
        ebook.setDescription(ebookUpdate.getDescription());
        ebook.setPublishYear(ebookUpdate.getPublishYear());
        ebook.setLanguage(languageService.findById(ebookUpdate.getLanguageId()).get());
        ebook.setPublisher(publisherService.findById(ebookUpdate.getPublisherId()).get());
        ebook.setCategory(categoryService.findById(ebookUpdate.getCategoryId()).get());
        Ebook editedEbook = ebookService.save(ebook);
    return ResponseEntity.ok(EbookMapper.INSTANCE.toDto(editedEbook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
        ebookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
