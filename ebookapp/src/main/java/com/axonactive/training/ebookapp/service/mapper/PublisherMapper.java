package com.axonactive.training.ebookapp.service.mapper;

import com.axonactive.training.ebookapp.entity.Publisher;
import com.axonactive.training.ebookapp.service.dto.PublisherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);
    PublisherDto toDto(Publisher publisher);
    List<PublisherDto> toDtos(List<Publisher> publishers);
}
