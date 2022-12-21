package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.CategoryDao;
import com.temzu.freshcafe.dao.ProductDao;
import com.temzu.freshcafe.dtos.ProductCreateDto;
import com.temzu.freshcafe.dtos.ProductDto;
import com.temzu.freshcafe.dtos.ProductUpdateDto;
import com.temzu.freshcafe.entities.Product;
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

  @Transactional
  @Override
  public ProductDto save(ProductCreateDto productCreateDto) {
    Product newProduct = new Product();
    newProduct.setTitle(productCreateDto.getTitle());
    newProduct.setPrice(productCreateDto.getPrice());
    newProduct.setCategory(categoryDao.findByTitle(productCreateDto.getCategoryTitle()));
    newProduct.setActiveStatus(true);
    productDao.saveOrUpdate(newProduct);
    return productMapper.toProductDto(newProduct);
  }

  @Override
  public ProductDto update(Long id, ProductUpdateDto productUpdateDto) {
    Product product = productDao.findById(id);
    product.setTitle(productUpdateDto.getTitle());
    product.setPrice(productUpdateDto.getPrice());
    Product updatedProduct = productDao.saveOrUpdate(product);
    return productMapper.toProductDto(updatedProduct);
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    productDao.deleteById(id);
  }

  @Override
  public void uploadProductImage(Long id, String imageUrl) {
    productDao.findById(id).setImageName(imageUrl);
  }
}
