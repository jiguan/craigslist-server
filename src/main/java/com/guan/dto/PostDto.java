package com.guan.dto;

import com.guan.domain.Post;

import lombok.Data;

@Data
public class PostDto {
   private String id, title, detail, category;
   public PostDto() {}
   public PostDto(Post post) {
      this.title = post.getTitle();
      this.id = post.getId().toHexString();
      this.detail = post.getDetail();
      this.category = post.getCategory();
   }
   
}

