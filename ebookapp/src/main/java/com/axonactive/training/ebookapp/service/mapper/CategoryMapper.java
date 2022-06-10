package com.axonactive.training.ebookapp.service.mapper;

import com.axonactive.training.ebookapp.entity.Category;
import com.axonactive.training.ebookapp.service.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "category.value", target = "categoryValue")

    CategoryDto toDto(Category category);

    List<CategoryDto> toDtos(List<Category> categories);
}
