package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.EbookRequest;
import com.axonactive.training.ebookapp.entity.Ebook;
import com.axonactive.training.ebookapp.exception.ApiException;
import com.axonactive.training.ebookapp.service.*;
import com.axonactive.training.ebookapp.service.dto.EbookDto;
import com.axonactive.training.ebookapp.service.mapper.EbookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<EbookDto> getEbookById(@PathVariable(value = "id") Integer id) {
        Ebook ebook = ebookService.findById(id)
                .orElseThrow(ApiException::EbookNotFound);
        return ResponseEntity.ok().body(EbookMapper.INSTANCE.toDto(ebook));
    }

    @PostMapping
    public ResponseEntity<EbookDto> create(@RequestBody EbookRequest ebook) {
        Ebook createdEbook = ebookService.save(new Ebook(
                ebook.getTitle(),
                ebook.getDescription(),
                ebook.getPublishYear(),
                languageService.findById(ebook.getLanguageId()).get(),
                publisherService.findById(ebook.getPublisherId()).get(),
                categoryService.findById(ebook.getCategoryId()).get()));

        return ResponseEntity.created(URI.create(PATH + "/" + createdEbook.getId())).body(EbookMapper.INSTANCE.toDto(createdEbook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EbookDto> update(@PathVariable(value = "id") Integer id, @RequestBody EbookRequest ebookUpdate) {
        Ebook ebook = ebookService.findById(id).orElseThrow(ApiException::EbookNotFound);
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
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        ebookService.findById(id).orElseThrow(ApiException::EbookNotFound);
        ebookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
