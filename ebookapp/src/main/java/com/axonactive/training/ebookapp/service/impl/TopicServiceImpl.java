package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.Topic;
import com.axonactive.training.ebookapp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicService topicService;

    @Override
    public List<Topic> getAll() {
        return topicService.getAll();
    }

    @Override
    public Topic save(Topic topic) {
        return topicService.save(topic);
    }

    @Override
    public Optional<Topic> findById(Integer id) {
        return topicService.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        topicService.deleteById(id);
    }
}
