package com.axonactive.training.ebookapp.repository;

import com.axonactive.training.ebookapp.entity.Subtopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtopicRepository extends JpaRepository<Subtopic, Integer> {
}
