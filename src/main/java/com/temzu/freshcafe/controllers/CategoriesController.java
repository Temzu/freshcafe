package com.temzu.freshcafe.controllers;

import com.temzu.freshcafe.dtos.CategoryDto;
import com.temzu.freshcafe.dtos.ProductDto;
import com.temzu.freshcafe.services.CategoryService;
import com.temzu.freshcafe.services.ProductService;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoriesController {

  private final CategoryService categoryService;

  private final ProductService productService;

  @GetMapping
  public Page<CategoryDto> findPage(
      @RequestParam(name = "page", defaultValue = "1") Integer page,
      @RequestParam(name = "page_size", defaultValue = "20") Integer pageSize) {
    if (page < 1 || pageSize < 1) {
      page = 1;
      pageSize = 20;
    }
    return categoryService.findPage(page, pageSize);
  }

  @GetMapping("/set")
  public List<CategoryDto> findAll() {
    return categoryService.findAll();
  }

  @GetMapping("/{category_title}")
  public Page<ProductDto> findPageByCategory(
      @PathVariable(name = "category_title") String categoryTitle,
      @RequestParam(name = "page", defaultValue = "1") Integer page,
      @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize) {
    if (page < 1 || pageSize < 1) {
      page = 1;
      pageSize = 10;
    }
    return productService.findPageByCategoryTitle(categoryTitle, page, pageSize);
  }

}
