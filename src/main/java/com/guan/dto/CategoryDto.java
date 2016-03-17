package com.guan.dto;

import com.guan.domain.Category;

import lombok.Value;

@Value
public class CategoryDto {
   private String id;
   private String name;
   public CategoryDto(Category category) {
      super();
      this.id = category.getId();
      this.name = category.getName();
   }
}
