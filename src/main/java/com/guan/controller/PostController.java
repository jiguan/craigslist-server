package com.guan.controller;

import com.guan.domain.Post;
import com.guan.dto.PostDto;
import com.guan.service.PostService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {
   private Logger LOGGER = LoggerFactory.getLogger(PostController.class);
      @Autowired
      private PostService service;
   
      @RequestMapping("/")
      public String index() {
         return "Greetings from Spring Boot!";
      }
      
      @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
      public Post getPost(@PathVariable("id") String id) {
         return service.getPost(id);
      }
      
      @RequestMapping(value = "/posts", method = RequestMethod.GET)
      public List<PostDto> getAllPosts() {
         List<PostDto> dtos = new ArrayList<>();
         for(Post p : service.getAllPosts()) {
            dtos.add(new PostDto(p));
         }
         LOGGER.info("Posts size: {}", dtos.size());
         return dtos;
      }
      
      @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
      public Post updatePost(@PathVariable("id") String id) {
        Post post =  service.getPost(id);
        return post;
      }
       
}
