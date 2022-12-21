package com.temzu.freshcafe.dao.impl;

import com.temzu.freshcafe.dao.CategoryDao;
import com.temzu.freshcafe.dtos.CategoryDto;
import com.temzu.freshcafe.entities.Category;
import com.temzu.freshcafe.exceptions.ResourceNotFoundException;
import com.temzu.freshcafe.repositories.CategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

  private final CategoryRepository categoryRepository;

  @Override
  public Page<Category> findPage(int page, int pageSize) {
    return categoryRepository.findAllByActiveStatusTrue(PageRequest.of(page - 1, pageSize));
  }

  @Override
  public Page<Category> findPageAll(int page, int pageSize) {
    return categoryRepository.findAll(PageRequest.of(page - 1, pageSize));
  }

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

  @Override
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category create(Category category) {
    category.setActiveStatus(true);
    return categoryRepository.save(category);
  }

  @Override
  public void deleteById(Long id) {
    findById(id).setActiveStatus(false);
  }

  @Override
  public Category update(Category toCategory) {
    return categoryRepository.save(toCategory);
  }
}
