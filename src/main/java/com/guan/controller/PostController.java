package com.guan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guan.domain.Post;
import com.guan.dto.PostDto;
import com.guan.service.PostService;

import io.swagger.annotations.ApiOperation;

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
   
   @RequestMapping(value = "/", method = RequestMethod.POST)
   @ApiOperation(value = "Save a post under the assgined category")
   public Post createPost(@RequestBody PostDto dto) {
      Post post = service.createPost(dto);
      return post;
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   @ApiOperation(value = "Update a post, id and category cannot be changed")
   public Post updatePost(@PathVariable("id") String id, @RequestBody PostDto dto) {
      return service.updatePost(id, dto);
   }
   

}
