package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.LanguageRequest;
import com.axonactive.training.ebookapp.entity.Language;
import com.axonactive.training.ebookapp.service.LanguageService;
import com.axonactive.training.ebookapp.service.dto.LanguageDto;
import com.axonactive.training.ebookapp.service.mapper.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(LanguageResources.PATH)
public class LanguageResources {
    public static final String PATH = "/api/languages";

    @Autowired
    LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAll() {
        List<Language> languageList = languageService.getAll();
        return ResponseEntity.ok(LanguageMapper.INSTANCE.toDtos(languageList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Integer id) throws ResourceNotFoundException {
        Language language = languageService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return ResponseEntity.ok().body(LanguageMapper.INSTANCE.toDto(language));
    }

    @PostMapping
    public ResponseEntity<LanguageDto> create(@RequestBody LanguageRequest language) {
        Language createdLanguage = languageService.save(new Language(
                null, language.getName(), language.getCode()));
        return ResponseEntity.created(URI.create(PATH + "/" + createdLanguage.getId()))
                .body(LanguageMapper.INSTANCE.toDto(createdLanguage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDto> update(@PathVariable(value = "id") Integer id,
                                              @RequestBody LanguageRequest languageUpdate) throws ResourceNotFoundException {
        Language language = languageService.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not found: " + id));
        language.setName(languageUpdate.getName());
        language.setCode(languageUpdate.getCode());
        Language editedLanguage = languageService.save(language);
        return ResponseEntity.ok(LanguageMapper.INSTANCE.toDto(editedLanguage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        languageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
