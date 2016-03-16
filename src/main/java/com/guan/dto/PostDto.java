package com.guan.dto;

import com.guan.domain.Post;

import lombok.Value;

@Value
public class PostDto {
   String id;
   String title;
   String detail;
   String category;
   
   public PostDto(Post post) {
      this.title = post.getTitle();
      this.id = post.getId();
      this.detail = post.getDetail();
      this.category = post.getCategory();
   }
   
}

