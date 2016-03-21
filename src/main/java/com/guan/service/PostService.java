package com.guan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guan.domain.Post;
import com.guan.dto.PostDto;
import com.guan.repo.PostRepository;

@Service
public class PostService {
   private Logger LOGGER = LoggerFactory.getLogger(PostService.class);

   @Autowired
   private PostRepository repo;
   
   public List<Post> getPostsUnderCategory(String categoryId) {
      return repo.findAll().stream().filter(p -> p.getCategory().equals(categoryId)).collect(Collectors.toList());
   }

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

   public Post createPost(PostDto dto) {
     Post post = save(new Post(dto));
     return post;
   }
   
   public Post save(Post post) {
      return repo.save(post);
   }

   public Post updatePost(String id, PostDto dto) {
      Post post = getPost(id);
      post.setTitle(dto.getTitle());
      post.setDetail(dto.getDetail());
      return save(post);
   }

}
