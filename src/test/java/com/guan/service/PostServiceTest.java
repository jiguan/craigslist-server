package com.guan.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guan.Application;
import com.guan.config.EmbeddedMongoConfig;
import com.guan.domain.Category;
import com.guan.domain.Post;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, EmbeddedMongoConfig.class})
public class PostServiceTest {
   private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceTest.class);

//   @Mock
//   AddressDao addressDao;

   @InjectMocks
   private PostService postService;

   @Test
   public void testDbConnection() {
      List<Post> r = postService.getAllPosts();
      for(Post p : r) {
         LOGGER.info(p.toString());
      }
   }
   
   @Test
   public void testGetAllPosts() {
//      List<Post> posts = categoryService.getPosts();
//      for(Post p : posts) {
//         
//      }
   }
   
   @Test
   public void testSavePostUnderCertainCategory() {
     
   }

}
