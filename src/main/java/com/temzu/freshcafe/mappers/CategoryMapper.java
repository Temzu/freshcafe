package com.temzu.freshcafe.mappers;

import com.temzu.freshcafe.dtos.CategoryCreateDto;
import com.temzu.freshcafe.dtos.CategoryDto;
import com.temzu.freshcafe.dtos.CategoryUpdateDto;
import com.temzu.freshcafe.dtos.ProductDto;
import com.temzu.freshcafe.entities.Category;
import com.temzu.freshcafe.entities.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

  private final ModelMapper mapper;

  public CategoryDto toCategoryDto(Category category) {
    return mapper.map(category, CategoryDto.class);
  }

  public Category toCategory(CategoryCreateDto categoryCreateDto) {
    return mapper.map(categoryCreateDto, Category.class);
  }

  public Category toCategory(CategoryUpdateDto categoryUpdateDto) {
    return mapper.map(categoryUpdateDto, Category.class);
  }

}
