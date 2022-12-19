package com.temzu.freshcafe.services;

import com.temzu.freshcafe.dtos.CategoryCreateDto;
import com.temzu.freshcafe.dtos.CategoryDto;
import java.util.List;
import org.springframework.data.domain.Page;

public interface CategoryService {

  Page<CategoryDto> findPage(int page, int pageSize);

  List<CategoryDto> findAll();

  CategoryDto createCategory(CategoryCreateDto categoryCreateDto);

  void deleteById(Long id);
}
