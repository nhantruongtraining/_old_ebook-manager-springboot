package com.axonactive.training.ebookapp.service.mapper;

import com.axonactive.training.ebookapp.entity.Topic;
import com.axonactive.training.ebookapp.service.dto.TopicDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TopicMapper {
    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);
    @Mapping(source = "category.value", target = "category")
    TopicDto toDto(Topic topic);
    List<TopicDto> toDtos(List<Topic> topics);
}
