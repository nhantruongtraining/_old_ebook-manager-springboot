package com.axonactive.training.ebookapp.service;

import com.axonactive.training.ebookapp.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    List<Topic> getAll();
    Topic save(Topic topic);
    Optional<Topic> findById(Integer id);
    void deleteById(Integer id);
}
