package com.guan.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guan.domain.Category;
import com.guan.domain.Post;
import com.guan.dto.CategoryDto;
import com.guan.dto.PostDto;
import com.guan.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
   private Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
   
   @Autowired
   private CategoryService service;
   
   @RequestMapping(value = "/{:id}/posts", method = RequestMethod.GET)
   public List<PostDto> getPostsUnder(@PathVariable("id") String categoryId) {
      List<PostDto> dtos = new ArrayList<>();
      for(Post p : service.getPostsUnderCategory(categoryId)) {
         dtos.add(new PostDto(p));
      }
      LOGGER.info("Posts size: {}", dtos.size());
      return dtos;
   }
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public List<CategoryDto> getCategory() {
      List<CategoryDto> dtos = new ArrayList<>();
      for(Category c : service.getCategories()) {
         dtos.add(new CategoryDto(c));
      }
      LOGGER.info("Posts size: {}", dtos.size());
      return dtos;
   }
}
