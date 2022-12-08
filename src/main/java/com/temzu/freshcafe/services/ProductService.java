package com.temzu.freshcafe.services;

import com.temzu.freshcafe.dtos.ProductCreateDto;
import com.temzu.freshcafe.dtos.ProductDto;
import com.temzu.freshcafe.dtos.ProductUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;

public interface ProductService {

  Page<ProductDto> findPage(Integer page, Integer pageSize);

  Page<ProductDto> findPageByCategoryTitle(String categoryTitle, Integer page, Integer pageSize);

  ProductDto findById(Long id);

  ProductDto save(ProductCreateDto productCreateDto);

  ProductDto update(ProductUpdateDto productUpdateDto);

  void deleteById(Long id);

}
