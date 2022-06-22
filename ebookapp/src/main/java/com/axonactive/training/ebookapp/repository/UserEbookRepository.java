package com.axonactive.training.ebookapp.repository;

import com.axonactive.training.ebookapp.entity.UserEbook;
import com.axonactive.training.ebookapp.service.dto.UserEbookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEbookRepository extends JpaRepository<UserEbook, Integer> {

    @Query("SELECT new com.axonactive.training.ebookapp.service.dto.UserEbookDto(e.title, u.user.firstName, u.favorite, u.status) " +
            "FROM UserEbook u , Ebook e " +
            "WHERE u.favorite = TRUE AND u.ebook.id = e.id " +
            "ORDER BY e.title")
    List<UserEbookDto> returnAllFavorite();
}
