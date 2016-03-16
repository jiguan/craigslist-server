package com.guan.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guan.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}