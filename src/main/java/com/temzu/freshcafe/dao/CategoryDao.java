package com.temzu.freshcafe.dao;

import com.temzu.freshcafe.entities.Category;
import org.springframework.data.domain.Page;

public interface CategoryDao {

  Page<Category> findPage(int page, int pageSize);

  Category findById(Long id);

  Category findByTitle(String title);
}
