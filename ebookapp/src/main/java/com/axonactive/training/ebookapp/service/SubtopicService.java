package com.axonactive.training.ebookapp.service;

import com.axonactive.training.ebookapp.entity.Author;
import com.axonactive.training.ebookapp.entity.Subtopic;

import java.util.List;
import java.util.Optional;

public interface SubtopicService {
    List<Subtopic> getAll();
    Subtopic save(Subtopic subtopic);
    Optional<Subtopic> findById(Integer id);
    void deleteById(Integer id);
}
