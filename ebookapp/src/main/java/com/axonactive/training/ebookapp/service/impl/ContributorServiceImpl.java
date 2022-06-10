package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.entity.Contributor;
import com.axonactive.training.ebookapp.repository.ContributorRepository;
import com.axonactive.training.ebookapp.service.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContributorServiceImpl implements ContributorService{
    @Autowired
    ContributorRepository contributorRepository;


    @Override
    public List<Contributor> getAll() {
        return contributorRepository.findAll();
    }

    @Override
    public Contributor save(Contributor contributor) {
        return contributorRepository.save(contributor);
    }

    @Override
    public Optional<Contributor> findById(Integer id) {
        return contributorRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        contributorRepository.deleteById(id);
    }
}
