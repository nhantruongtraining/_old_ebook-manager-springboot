package com.axonactive.training.ebookapp.service.mapper;

import com.axonactive.training.ebookapp.entity.Language;
import com.axonactive.training.ebookapp.service.dto.LanguageDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);
    LanguageDto toDto(Language language);
    List<LanguageDto> toDtos(List<Language> languages);
}
