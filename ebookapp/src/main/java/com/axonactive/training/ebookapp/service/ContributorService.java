package com.axonactive.training.ebookapp.service;

import com.axonactive.training.ebookapp.entity.Contributor;

import java.util.List;
import java.util.Optional;

public interface ContributorService {
    List<Contributor> getAll();
    Contributor save(Contributor contributor);
    Optional<Contributor> findById(Integer id);
    void deleteById(Integer id);
}
