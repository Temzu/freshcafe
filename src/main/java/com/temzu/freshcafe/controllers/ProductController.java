package com.temzu.freshcafe.controllers;

import com.temzu.freshcafe.dtos.ProductCreateDto;
import com.temzu.freshcafe.dtos.ProductDto;
import com.temzu.freshcafe.dtos.ProductUpdateDto;
import com.temzu.freshcafe.services.ProductService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public Page<ProductDto> findPage(
      @RequestParam(name = "page", defaultValue = "1") Integer page,
      @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize) {
    if (page < 1 || pageSize < 1) {
      page = 1;
      pageSize = 10;
    }
    return productService.findPage(page, pageSize);
  }

  @GetMapping("/title/{category_title}")
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


  @GetMapping("/{id}")
  public ProductDto findById(@PathVariable Long id) {
    return productService.findById(id);
  }

//  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping
  public ProductDto save(@Valid @RequestBody ProductCreateDto productCreateDto) {
    return productService.save(productCreateDto);
  }

//  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping
  public ProductDto update(@Valid @RequestBody ProductUpdateDto productUpdateDto) {
    return productService.update(productUpdateDto);
  }

//  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    productService.deleteById(id);
  }

}
