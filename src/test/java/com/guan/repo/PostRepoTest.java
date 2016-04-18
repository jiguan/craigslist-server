package com.guan.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guan.Application;
import com.guan.service.PostService;
import com.guan.util.PrettyPrint;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class PostRepoTest {
   @Autowired
   private PostRepository repo;
   
   @Autowired
   private PostService service;
   
   @Test
   public void testGetAllCategory() {
      repo.findAll().stream().forEach(p -> System.out.println(PrettyPrint.toJson(p)));
   }
   
   @Test
   public void testGetPostsUnderCategory() {
      String categoryId = "56ec20c3ad683ea4f5bf522a";
      service.getPostsOfCategory(categoryId).stream().forEach(p -> System.out.println(PrettyPrint.toJson(p)));
   }
   
   @Test
   public void test() {
       assertNotNull(repo.findAll());
   }

}
