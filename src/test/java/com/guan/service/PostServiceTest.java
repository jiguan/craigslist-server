package com.guan.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guan.MaoApplication;
import com.guan.domain.Post;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MaoApplication.class)
public class PostServiceTest {
   private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceTest.class);

   @Autowired
   PostService service;

   @Test
   public void testDbConnection() {
      List<Post> r = service.getAllPosts();
      for(Post p : r) {
         LOGGER.info(p.toString());
      }
   }

}
