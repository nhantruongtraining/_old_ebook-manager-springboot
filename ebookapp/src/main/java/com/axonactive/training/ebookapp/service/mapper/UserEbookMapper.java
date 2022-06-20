package com.axonactive.training.ebookapp.service.mapper;

import com.axonactive.training.ebookapp.entity.UserEbook;
import com.axonactive.training.ebookapp.service.dto.UserEbookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserEbookMapper {
    UserEbookMapper INSTANCE = Mappers.getMapper(UserEbookMapper.class);
    @Mapping(source = "ebook.title", target = "ebookTitle")
    @Mapping(source = "user.username", target = "ebookOwner")
    UserEbookDto toDto(UserEbook userEbook);
    List<UserEbookDto> toDtos(List<UserEbook> userEbooks);
}
