package com.guan.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import com.guan.dto.CategoryDto;

import lombok.Data;

@Data @Document
public class Category {
   private String id;
   private String name;
   private List<Post> posts = new ArrayList<>();
   public Category() {}
   public Category(String name) {
      Assert.hasText(name, "Name must not be null or empty!");
      this.name = name;
   }
   public Category(CategoryDto dto) {
      Assert.hasText(dto.getName(), "Name must not be null or empty!");
      this.name = dto.getName();
   }
}
