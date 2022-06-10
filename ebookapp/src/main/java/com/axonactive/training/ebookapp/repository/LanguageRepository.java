package com.axonactive.training.ebookapp.repository;

import com.axonactive.training.ebookapp.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
