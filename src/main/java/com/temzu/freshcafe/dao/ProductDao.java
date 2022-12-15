package com.temzu.freshcafe.dao;

import com.temzu.freshcafe.entities.Category;
import com.temzu.freshcafe.entities.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

public interface ProductDao {

  Page<Product> findPage(int page, int pageSize);

  Page<Product> findPageByCategory(Category category, int page, int pageSize);

  List<Product> findAllByIdIsIn(List<Long> ids);

  Product findById(Long id);

  boolean existById(Long id);

  Product saveOrUpdate(Product product);

  void deleteById(Long id);
}
