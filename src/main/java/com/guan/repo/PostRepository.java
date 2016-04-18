package com.guan.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guan.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    public List<Post> findByUsername(String username);
    public List<Post> findByCategoryId(String categoryId);
}