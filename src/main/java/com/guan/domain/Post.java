package com.guan.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import com.guan.dto.PostDto;

import lombok.Data;

@Data
@Document
public class Post {
   @Id
   private ObjectId id;
   private String title, detail;
   
   @Indexed
   private String category;
   public Post() {}
   public Post(String title, String detail, String category) {
      Assert.hasText(title, "Title must not be null or empty!");
      Assert.hasText(detail, "Detail must not be null or empty!");
      Assert.hasText(category, "Category must not be null or empty!");
      this.title = title;
      this.detail = detail;
      this.category = category;
   }
   
   public Post(PostDto dto) {
      Assert.hasText(dto.getTitle(), "Title must not be null or empty!");
      Assert.hasText(dto.getDetail(), "Detail must not be null or empty!");
      Assert.hasText(dto.getCategory(), "Category must not be null or empty!");
      this.title = dto.getTitle();
      this.detail = dto.getDetail();
      this.category = dto.getCategory();
   }
}
