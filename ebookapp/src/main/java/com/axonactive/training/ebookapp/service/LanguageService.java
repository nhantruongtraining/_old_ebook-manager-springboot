package com.axonactive.training.ebookapp.service;

import com.axonactive.training.ebookapp.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    List<Language> getAll();
    Language save(Language language);
    Optional<Language> findById(Integer id);
    void deleteById(Integer id);
}
