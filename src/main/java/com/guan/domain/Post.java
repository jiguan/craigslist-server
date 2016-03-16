package com.guan.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import lombok.Data;

@Data
@Document
public class Post {
   private String id, title, detail, category;

   public Post(String title, String detail, String category) {
      Assert.hasText(title, "Title must not be null or empty!");
      Assert.hasText(detail, "Detail must not be null or empty!");
      Assert.hasText(category, "Category must not be null or empty!");

      this.title = title;
      this.detail = detail;
      this.category = category;
   }
}
