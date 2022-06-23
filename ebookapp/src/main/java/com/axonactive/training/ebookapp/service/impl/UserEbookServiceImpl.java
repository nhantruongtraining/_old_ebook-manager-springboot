package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.UserEbook;
import com.axonactive.training.ebookapp.repository.UserEbookRepository;
import com.axonactive.training.ebookapp.service.UserEbookService;
import com.axonactive.training.ebookapp.service.dto.UserEbookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
//        userEbookRepository.findById(id).orElseThrow(DemoException::UserEbookNotFound);
        return userEbookRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userEbookRepository.deleteById(id);
    }

    @Override
    public List<UserEbook> findByEbookTitleContaining(String ebookTitle) {
        return userEbookRepository.findByEbookTitleContaining(ebookTitle);
    }

    @Override
    public List<UserEbookDto> returnAllFavorite() {
        return userEbookRepository.returnAllFavorite();
    }
}
