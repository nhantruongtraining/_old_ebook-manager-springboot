package com.axonactive.training.ebookapp.repository;

import com.axonactive.training.ebookapp.entity.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Integer> {
}
