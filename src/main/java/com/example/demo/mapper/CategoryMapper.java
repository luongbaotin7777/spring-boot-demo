package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dtos.CategoryRequestDtos;
import com.example.demo.dtos.CategoryResponseDtos;
import com.example.demo.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryResponseDtos toCategoryDTO(Category category);

    List<CategoryResponseDtos> toCategoryDTOs(List<Category> categories);

    Category toCategory(CategoryRequestDtos categoryDTO);
}
