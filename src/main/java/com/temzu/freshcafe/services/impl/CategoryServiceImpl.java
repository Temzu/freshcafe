package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.CategoryDao;
import com.temzu.freshcafe.dtos.CategoryDto;
import com.temzu.freshcafe.mappers.CategoryMapper;
import com.temzu.freshcafe.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDao categoryDao;

  private final CategoryMapper categoryMapper;

  @Override
  public Page<CategoryDto> findPage(int page, int pageSize) {
    return categoryDao.findPage(page, pageSize).map(categoryMapper::toCategoryDto);
  }
}
