package com.guan.controller;

import com.guan.domain.Post;
import com.guan.service.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
   
      @Autowired
      private PostService service;
   
      private final Logger logger = LoggerFactory.getLogger(this.getClass());

      @RequestMapping("/")
      public String index() {
         return "Greetings from Spring Boot!";
      }
      
      @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      public Post getPost(@PathVariable("id") long id) {
         return service.getPost(id);
      }
      
      @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
      public Post updatePost(@PathVariable("id") long id) {
        Post post =  service.getPost(id);
        return post;
      }
       
}
