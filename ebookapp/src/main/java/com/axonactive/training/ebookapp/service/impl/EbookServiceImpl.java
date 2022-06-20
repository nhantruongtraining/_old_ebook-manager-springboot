package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.Ebook;
import com.axonactive.training.ebookapp.repository.EbookRepository;
import com.axonactive.training.ebookapp.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EbookServiceImpl implements EbookService {
    @Autowired
    EbookRepository ebookRepository;

    @Override
    public List<Ebook> getAll() {
        return ebookRepository.findAll();
    }

    @Override
    public Ebook save(Ebook ebook) {
       return ebookRepository.save(ebook);
    }

    @Override
    public Optional<Ebook> findById(Integer id) {
        return ebookRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        ebookRepository.deleteById(id);
    }
}
