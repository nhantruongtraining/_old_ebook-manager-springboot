package com.axonactive.training.ebookapp.service.mapper;

import com.axonactive.training.ebookapp.entity.Contributor;
import com.axonactive.training.ebookapp.service.dto.ContributorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContributorMapper {
    ContributorMapper INSTANCE = Mappers.getMapper(ContributorMapper.class);
    @Mapping(source = "ebook.title", target = "ebookTitle")
    @Mapping(source = "author.firstName", target = "authorFirstName")
    @Mapping(source = "author.lastName", target = "authorLastName")
    ContributorDto toDto(Contributor contributor);
    List<ContributorDto> toDtos(List<Contributor> contributors);
}
