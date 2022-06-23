package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.LanguageRequest;
import com.axonactive.training.ebookapp.entity.Language;
import com.axonactive.training.ebookapp.exception.ApiException;
import com.axonactive.training.ebookapp.service.LanguageService;
import com.axonactive.training.ebookapp.service.dto.LanguageDto;
import com.axonactive.training.ebookapp.service.mapper.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable(value = "id") Integer id) {
        Language language = languageService.findById(id)
                .orElseThrow(ApiException::LanguageNotFound);
        return ResponseEntity.ok().body(LanguageMapper.INSTANCE.toDto(language));
    }

    @PostMapping
    public ResponseEntity<LanguageDto> create(@RequestBody LanguageRequest languageRequest) {
        Language language = new Language();
        language.setName(languageRequest.getName());
        language.setCode(languageRequest.getCode());

        Language createdLanguage = languageService.save(language);

        return ResponseEntity.created(URI.create(PATH + "/" + createdLanguage.getId()))
                .body(LanguageMapper.INSTANCE.toDto(createdLanguage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDto> update(@PathVariable(value = "id") Integer id,
                                              @RequestBody LanguageRequest languageUpdate) {
        Language language = languageService.findById(id).orElseThrow(ApiException::LanguageNotFound);
        language.setName(languageUpdate.getName());
        language.setCode(languageUpdate.getCode());
        Language editedLanguage = languageService.save(language);
        return ResponseEntity.ok(LanguageMapper.INSTANCE.toDto(editedLanguage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
        languageService.findById(id).orElseThrow(ApiException::LanguageNotFound);
        languageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
