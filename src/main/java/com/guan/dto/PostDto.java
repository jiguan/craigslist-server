package com.guan.dto;

import java.util.Date;

import com.guan.domain.Post;

import lombok.Data;

@Data
public class PostDto {
   private String id, title, detail, categoryId, username;
   private Date timestamp;
   public PostDto() {}
   public PostDto(Post post) {
      this.title = post.getTitle();
      this.id = post.getId().toHexString();
      this.detail = post.getDetail();
      this.categoryId = post.getCategoryId();
      this.timestamp = post.getId().getDate();
      this.username = post.getUsername();
   }
   
}



