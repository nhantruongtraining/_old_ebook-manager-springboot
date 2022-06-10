package com.axonactive.training.ebookapp.service.mapper;

import com.axonactive.training.ebookapp.entity.Subtopic;
import com.axonactive.training.ebookapp.service.dto.SubtopicDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubtopicMapper {
    SubtopicMapper INSTANCE = Mappers.getMapper(SubtopicMapper.class);
    @Mapping(source = "subtopic.value", target = "subTopicValue")
    @Mapping(source = "topic.value", target = "topic")
    SubtopicDto toDto(Subtopic subtopic);
    List<SubtopicDto> toDtos(List<Subtopic> subtopics);

}
