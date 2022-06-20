package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.Ebook;
import com.axonactive.training.ebookapp.entity.UserEbook;
import com.axonactive.training.ebookapp.repository.UserEbookRepository;
import com.axonactive.training.ebookapp.service.UserEbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEbookServiceImpl implements UserEbookService {
    @Autowired
    UserEbookRepository userEbookRepository;


    @Override
    public List<UserEbook> getAll() {
        return userEbookRepository.findAll();
    }

    @Override
    public UserEbook save(UserEbook ebook) {
        return userEbookRepository.save(ebook);
    }

    @Override
    public Optional<UserEbook> findById(Integer id) {
        return userEbookRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userEbookRepository.deleteById(id);
    }
}
