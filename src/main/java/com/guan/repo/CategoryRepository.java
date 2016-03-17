package com.guan.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guan.domain.Category;

public interface CategoryRepository extends MongoRepository<Category, String>{

}
