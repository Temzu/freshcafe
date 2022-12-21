package com.temzu.freshcafe.services.impl;

import com.temzu.freshcafe.dao.CategoryDao;
import com.temzu.freshcafe.dtos.CategoryCreateDto;
import com.temzu.freshcafe.dtos.CategoryDto;
import com.temzu.freshcafe.dtos.CategoryUpdateDto;
import com.temzu.freshcafe.entities.Category;
import com.temzu.freshcafe.mappers.CategoryMapper;
import com.temzu.freshcafe.services.CategoryService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDao categoryDao;

  private final CategoryMapper categoryMapper;

  @Override
  public Page<CategoryDto> findPage(int page, int pageSize) {
    return categoryDao.findPage(page, pageSize).map(categoryMapper::toCategoryDto);
  }

  @Override
  public Page<CategoryDto> findPageAll(int page, int pageSize) {
    return categoryDao.findPageAll(page, pageSize).map(categoryMapper::toCategoryDto);
  }

  @Override
  public List<CategoryDto> findAll() {
    return categoryDao.findAll().stream()
        .map(categoryMapper::toCategoryDto)
        .collect(Collectors.toList());
  }

  @Override
  public CategoryDto createCategory(CategoryCreateDto categoryCreateDto) {
    return categoryMapper.toCategoryDto(
        categoryDao.create(categoryMapper.toCategory(categoryCreateDto)));
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    categoryDao.deleteById(id);
  }

  @Transactional
  @Override
  public CategoryDto update(CategoryUpdateDto categoryUpdateDto) {
    Category oldCategory = categoryDao.findById(categoryUpdateDto.getId());
    oldCategory.setTitle(categoryUpdateDto.getTitle());
    return categoryMapper.toCategoryDto(categoryDao.update(oldCategory));
  }

  @Transactional
  @Override
  public void uploadCategoryImage(Long id, String imageUrl) {
//    StringBuilder fileNames = new StringBuilder();
//    Path fileNameAndPath = Paths.get("src\\main\\resources\\static\\images\\categories", file.getOriginalFilename());
//    fileNames.append(file.getOriginalFilename());
//    try {
//      Files.write(fileNameAndPath, file.getBytes());
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
    categoryDao.findById(id).setImageName(imageUrl);
  }
}
