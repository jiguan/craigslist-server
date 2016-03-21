package com.guan.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guan.Application;
import com.guan.config.TestMongoConfig;
import com.guan.domain.Category;
import com.guan.domain.Post;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, TestMongoConfig.class})
public class CategoryServiceTest {
   Logger LOGGER = LoggerFactory.getLogger(CategoryServiceTest.class);
   
   @Autowired
   private CategoryService categoryService;
   @Autowired
   private PostService postService;
   
   @Test
   public void test() {
      Category category = new Category("Test category");
      categoryService.save(category);
      LOGGER.info("Category: {}", category.getId());
   }
   
  
   

}
