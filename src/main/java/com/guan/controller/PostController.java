package com.guan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guan.domain.Post;
import com.guan.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
   private Logger LOGGER = LoggerFactory.getLogger(PostController.class);

   @Autowired
   private PostService service;

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Post getPost(@PathVariable("id") String id) {
      return service.getPost(id);
   }

   @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
   public Post updatePost(@PathVariable("id") String id) {
      Post post = service.getPost(id);
      return post;
   }

}
