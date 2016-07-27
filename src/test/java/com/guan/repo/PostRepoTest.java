package com.guan.repo;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guan.Application;
import com.guan.service.PostService;
import com.guan.util.PrettyPrint;
import com.guan.util.URLUtil;

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
   public void test() throws Exception {
       List<String> s = new LinkedList<>();
       System.out.println(s.remove("as"));
   }

}
