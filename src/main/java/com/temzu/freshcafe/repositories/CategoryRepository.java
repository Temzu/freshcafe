package com.temzu.freshcafe.repositories;

import com.temzu.freshcafe.entities.Category;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findByTitle(String title);

  Page<Category> findAllByActiveStatusTrue(Pageable pageable);

}
