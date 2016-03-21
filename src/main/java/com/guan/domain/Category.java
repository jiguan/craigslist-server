package com.guan.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import com.guan.dto.CategoryDto;

import lombok.Data;

@Data @Document
public class Category {
   @Id
   private String id;
   private String name;
   
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
