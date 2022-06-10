package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.Subtopic;
import com.axonactive.training.ebookapp.service.SubtopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubtopicServiceImpl implements SubtopicService {
    @Autowired
    SubtopicService subtopicService;

    @Override
    public List<Subtopic> getAll() {
        return subtopicService.getAll();
    }

    @Override
    public Subtopic save(Subtopic subtopic) {
        return subtopicService.save(subtopic);
    }

    @Override
    public Optional<Subtopic> findById(Integer id) {
        return subtopicService.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        subtopicService.deleteById(id);
    }
}
