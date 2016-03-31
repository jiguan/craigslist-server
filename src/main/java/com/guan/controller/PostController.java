package com.guan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guan.domain.Post;
import com.guan.dto.CommentDto;
import com.guan.dto.PostDto;
import com.guan.service.PostService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/post")
public class PostController extends Controller {
   private Logger LOGGER = LoggerFactory.getLogger(PostController.class);

   @Autowired
   private PostService service;
   
   
   @RequestMapping(value = "/", method = RequestMethod.POST)
   @ApiOperation(value = "Save a post under the assgined category")
   public PostDto createPost(@RequestBody PostDto dto) {
      Post post = service.createPost(dto);
      return new PostDto(post);
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public PostDto getPost(@PathVariable("id") String id) {
      return new PostDto(service.getPost(id));
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   @ApiOperation(value = "Update a post, id and category cannot be changed")
   public PostDto updatePost(@PathVariable("id") String id, @RequestBody PostDto dto) {
      return new PostDto(service.updatePost(id, dto));
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   @ApiOperation(value = "Remove record completely")
   public ResponseEntity<String> deletePost(@PathVariable("id") String id) {
      service.deletePost(id);
      return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
   }
   
   @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
   @ApiOperation(value = "Add a comment under the post")
   public PostDto createComment (@PathVariable("id") String id, @RequestBody CommentDto dto) {
      return new PostDto(service.addComment(id, dto));
   }
   
}
