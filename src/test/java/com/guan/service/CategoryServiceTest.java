package com.guan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.guan.Application;
import com.guan.domain.Category;
import com.guan.repo.CategoryRepository;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class CategoryServiceTest {
   Logger LOGGER = LoggerFactory.getLogger(CategoryServiceTest.class);
   
   @InjectMocks
   private CategoryService categoryService;
   
   @Mock
   CategoryRepository repo;
   
   @Test
   public void test() {
      Category category = new Category("Test category");
      Category category2 = new Category("Test category2");
      category2.setId("2");
      Mockito.when(repo.save(category)).thenReturn(category2);
      ReflectionTestUtils.setField(categoryService, "repo", repo);
      LOGGER.info("Category: {}", categoryService.saveCategory(category).getId());
   }
   
  
   

}
