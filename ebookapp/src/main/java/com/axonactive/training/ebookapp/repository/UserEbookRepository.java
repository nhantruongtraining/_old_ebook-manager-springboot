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

    // Lookup ebook by names
    List<UserEbook> findByEbookTitleContaining(String ebookTitle);

    @Query("SELECT new com.axonactive.training.ebookapp.service.dto.UserEbookDto(e.title, u.username, ue.favorite, ue.status) " +
            "FROM UserEbook ue , Ebook e, User u " +
            "WHERE ue.ebook.id = e.id AND ue.user.id = u.id AND ue.favorite = TRUE AND u.id = 2 " +
            "ORDER BY e.title")
    List<UserEbookDto> returnAllFavorite(@Param("userId") Integer userID);
}
