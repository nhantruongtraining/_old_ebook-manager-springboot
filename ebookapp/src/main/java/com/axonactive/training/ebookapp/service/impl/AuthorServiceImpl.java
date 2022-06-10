package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.Author;
import com.axonactive.training.ebookapp.repository.AuthorRepository;
import com.axonactive.training.ebookapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }
}
