package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.CategoryDao;
import com.temzu.freshcafe.dtos.CategoryCreateDto;
import com.temzu.freshcafe.dtos.CategoryDto;
import com.temzu.freshcafe.mappers.CategoryMapper;
import com.temzu.freshcafe.services.CategoryService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDao categoryDao;

  private final CategoryMapper categoryMapper;

  @Override
  public Page<CategoryDto> findPage(int page, int pageSize) {
    return categoryDao.findPage(page, pageSize).map(categoryMapper::toCategoryDto);
  }

  @Override
  public List<CategoryDto> findAll() {
    return categoryDao.findAll().stream()
        .map(categoryMapper::toCategoryDto)
        .collect(Collectors.toList());
  }

  @Override
  public CategoryDto createCategory(CategoryCreateDto categoryCreateDto) {
    return null;
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    categoryDao.deleteById(id);
  }
}
