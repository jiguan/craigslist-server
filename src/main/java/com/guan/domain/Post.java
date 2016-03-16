package com.guan.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data @Document
public class Post {
   private Long id;
   private String title;
   private String detail;
   private Long category;
}
