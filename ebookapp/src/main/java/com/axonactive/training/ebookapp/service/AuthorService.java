package com.axonactive.training.ebookapp.service;

import com.axonactive.training.ebookapp.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAll();
    Author save(Author author);
    Optional<Author> findById(Integer id);
    void deleteById(Integer id);

}
