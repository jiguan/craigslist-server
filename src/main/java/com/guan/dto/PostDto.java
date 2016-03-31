package com.guan.dto;

import java.util.ArrayList;
import java.util.List;

import com.guan.domain.Post;

import lombok.Data;

@Data
public class PostDto {
   private String id, title, detail, category;
   private List<CommentDto> comments = new ArrayList<>();
   public PostDto() {}
   public PostDto(Post post) {
      this.title = post.getTitle();
      this.id = post.getId().toHexString();
      this.detail = post.getDetail();
      this.category = post.getCategory();
      post.getComments().stream().forEach(comment -> comments.add(new CommentDto(comment)));
   }
   
}

