package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.CategoryDao;
import com.temzu.freshcafe.dao.ProductDao;
import com.temzu.freshcafe.dtos.ProductCreateDto;
import com.temzu.freshcafe.dtos.ProductDto;
import com.temzu.freshcafe.dtos.ProductUpdateDto;
import com.temzu.freshcafe.mappers.ProductMapper;
import com.temzu.freshcafe.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductDao productDao;

  private final CategoryDao categoryDao;

  private final ProductMapper productMapper;

  @Override
  public Page<ProductDto> findPage(Integer page, Integer pageSize) {
    return productDao.findPage(page, pageSize).map(productMapper::toProductDto);
  }

  @Override
  public Page<ProductDto> findPageByCategoryTitle(
      String categoryTitle, Integer page, Integer pageSize) {
    return productDao
        .findPageByCategory(categoryDao.findByTitle(categoryTitle), page, pageSize)
        .map(productMapper::toProductDto);
  }

  @Override
  public ProductDto findById(Long id) {
    return productMapper.toProductDto(productDao.findById(id));
  }

  @Override
  public ProductDto save(ProductCreateDto productCreateDto) {
    return null;
  }

  @Override
  public ProductDto update(ProductUpdateDto productUpdateDto) {
    return null;
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    productDao.deleteById(id);
  }
}
