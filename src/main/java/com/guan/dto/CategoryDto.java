package com.guan.dto;

import com.guan.domain.Category;

import lombok.Data;

@Data
public class CategoryDto {
   private String id;
   private String name;
   public CategoryDto() {}
   public CategoryDto(Category category) {
      super();
      this.id = category.getId();
      this.name = category.getName();
   }
}
