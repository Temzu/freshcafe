package com.temzu.freshcafe.services;

import com.temzu.freshcafe.dtos.CategoryCreateDto;
import com.temzu.freshcafe.dtos.CategoryDto;
import com.temzu.freshcafe.dtos.CategoryUpdateDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface CategoryService {

  Page<CategoryDto> findPage(int page, int pageSize);

  Page<CategoryDto> findPageAll(int page, int pageSize);

  List<CategoryDto> findAll();

  CategoryDto createCategory(CategoryCreateDto categoryCreateDto);

  void deleteById(Long id);

  CategoryDto update(CategoryUpdateDto categoryUpdateDto);

  void uploadCategoryImage(Long id, String imageUrl);
}
