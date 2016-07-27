package com.guan.dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.guan.domain.Post;
import com.guan.util.URLUtil;

import lombok.Data;

@Data
public class PostDto {
   private String id, title, detail, categoryId, username;
   private Date timestamp;
   private List<String> files = new LinkedList<>();
   public PostDto() {}
   public PostDto(Post post) {
      this.title = post.getTitle();
      this.id = post.getId().toHexString();
      this.detail = post.getDetail();
      this.categoryId = post.getCategoryId();
      this.timestamp = post.getId().getDate();
      this.username = post.getUsername();
      this.files = post.getFiles().stream().map(f -> URLUtil.encode(f)).collect(Collectors.toList());

   }
   
}



