package com.guan.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guan.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

}