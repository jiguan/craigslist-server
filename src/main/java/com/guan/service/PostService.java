package com.guan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guan.domain.Post;
import com.guan.repo.PostRepository;

@Service
public class PostService {
   private Logger LOGGER = LoggerFactory.getLogger(PostService.class);

   @Autowired
   private PostRepository repo;

   public List<Post> getAllPosts() {
      List<Post> result = repo.findAll();
      for(Post p : result) {
         LOGGER.debug(p.getId()+"");
      }
      return result;
   }

   public Post getPost(String id) {
      return repo.findOne(id);
   }
}
