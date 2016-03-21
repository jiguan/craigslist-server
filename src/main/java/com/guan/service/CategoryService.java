package com.guan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guan.domain.Category;
import com.guan.dto.CategoryDto;
import com.guan.exceptions.ResourceNotFoundException;
import com.guan.repo.CategoryRepository;


@Service
public class CategoryService {
   static private Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

   @Autowired
   private CategoryRepository repo;

   public List<Category> getCategories() {
      return repo.findAll();
   }

   public Category getCategory(String id) {
      return repo.findOne(id);
   }

   public Category createCategory(CategoryDto dto) {
      return saveCategory(new Category(dto));
   }
   
   public Category saveCategory(Category category) {
      return repo.save(category);
   }

   public void deleteCategory(String id) {
      if (getCategory(id) != null) {
         LOGGER.warn("Delete category {}", id);
         repo.delete(id);
      } else {
         throw new ResourceNotFoundException(String.format("Category {} is not found", id));
      }
   }

   public Category updateCategory(String id, CategoryDto dto) {
      Category category = repo.findOne(id);
      category.setName(dto.getName());
      return saveCategory(category);
   }
}
