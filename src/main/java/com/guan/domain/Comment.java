package com.guan.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Comment {
   private String id;
   private String comment;
   private String user;
   
   public Comment(String comment, String user) {
      super();
      this.comment = comment;
      this.user = user;
   }
}
