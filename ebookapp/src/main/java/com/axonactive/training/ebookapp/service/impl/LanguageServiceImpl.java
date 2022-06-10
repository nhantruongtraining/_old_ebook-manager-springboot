package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.Language;
import com.axonactive.training.ebookapp.repository.LanguageRepository;
import com.axonactive.training.ebookapp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Optional<Language> findById(Integer id) {
        return languageRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        languageRepository.deleteById(id);
    }
}
