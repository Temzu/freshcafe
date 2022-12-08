package com.temzu.freshcafe.dao;

import com.temzu.freshcafe.entities.Category;

public interface CategoryDao {

  Category findById(Long id);

  Category findByTitle(String title);
}
