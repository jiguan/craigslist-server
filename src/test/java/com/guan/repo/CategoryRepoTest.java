package com.guan.repo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guan.Application;
import com.guan.domain.Category;
import com.guan.util.PrettyPrint;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class CategoryRepoTest {
   @Autowired
   private CategoryRepository repo;
   
   @Test
   public void testGetAllCategory() {
      List<Category> categories = repo.findAll();
      for(Category c : categories) {
         System.out.println(PrettyPrint.toJson(c));
      }
      
   }

}
