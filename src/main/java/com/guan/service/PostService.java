package com.guan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guan.dao.PostRepository;
import com.guan.domain.Post;

@Service
public class PostService {
   @Autowired 
   private PostRepository repo;
   
   public Post getPost(long id) {
      return repo.findOne(id);
   }
}
