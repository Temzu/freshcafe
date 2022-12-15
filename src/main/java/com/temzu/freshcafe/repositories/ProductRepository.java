package com.temzu.freshcafe.repositories;

import com.temzu.freshcafe.entities.Category;
import com.temzu.freshcafe.entities.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  Page<Product> findAllByCategory(Category category, Pageable pageable);

  List<Product> findAllByIdIsIn(List<Long> ids);

}
