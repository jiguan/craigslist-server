package com.guan.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guan.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{

    public List<Comment> findByPostId(String postId);
}
