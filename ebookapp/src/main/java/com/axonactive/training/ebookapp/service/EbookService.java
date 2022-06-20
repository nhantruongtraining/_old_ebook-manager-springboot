package com.axonactive.training.ebookapp.service;

import com.axonactive.training.ebookapp.entity.Ebook;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EbookService {
    List<Ebook> getAll();
    Ebook save(Ebook ebook);
    Optional<Ebook> findById(Integer id);
    void deleteById(Integer id);
}
