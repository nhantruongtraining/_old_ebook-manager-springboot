package com.axonactive.training.ebookapp.service;

import com.axonactive.training.ebookapp.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
    Optional<Category> findById(Integer id);
    void deleteById(Integer id);
}
