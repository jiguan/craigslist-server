package com.guan.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.guan.dto.CommentDto;

import lombok.Data;

@Data
@Document
public class Comment {
   @Id
   private ObjectId id;
   private String comment;
   private User user;
   public Comment() {}
   public Comment(CommentDto dto, User user) {
      this.comment = dto.getComment();
      this.user = user;
   }
}
