package com.axonactive.training.ebookapp.repository;

import com.axonactive.training.ebookapp.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Integer> {

    List<Ebook> findByTitleContainingIgnoreCase(String ebookTitle);
}
