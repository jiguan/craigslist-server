package com.guan.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guan.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
