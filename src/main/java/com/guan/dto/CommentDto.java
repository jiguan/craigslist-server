package com.guan.dto;

import com.guan.domain.Comment;

import lombok.Data;

@Data
public class CommentDto {
   private String id, comment, user;
   public CommentDto() {}
   public CommentDto(Comment comment) {
       if(comment.getId()!=null)
      this.id = comment.getId().toHexString();
      this.comment = comment.getComment();
      this.user = comment.getUser().getUsername();
   }

}
