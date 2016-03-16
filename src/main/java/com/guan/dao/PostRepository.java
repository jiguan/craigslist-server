package com.guan.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guan.domain.Post;

public interface PostRepository extends MongoRepository<Post, Long> {

   public Post findByCategory(Long id);

}