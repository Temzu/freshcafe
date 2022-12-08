package com.temzu.freshcafe.dao.impl;

import com.temzu.freshcafe.dao.CategoryDao;
import com.temzu.freshcafe.entities.Category;
import com.temzu.freshcafe.exceptions.ResourceNotFoundException;
import com.temzu.freshcafe.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

  private final CategoryRepository categoryRepository;

  @Override
  public Category findById(Long id) {
    return categoryRepository
        .findById(id)
        .orElseThrow(() -> ResourceNotFoundException.byId(id, Category.class));
  }

  @Override
  public Category findByTitle(String title) {
    return categoryRepository
        .findByTitle(title)
        .orElseThrow(() -> ResourceNotFoundException.byTitle(title, Category.class));
  }
}
