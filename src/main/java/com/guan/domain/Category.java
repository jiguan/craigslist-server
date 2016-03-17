package com.guan.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import lombok.Data;

@Data @Document
public class Category {
   private String id;
   private String name;
   private List<Post> posts = new ArrayList<>();
   
   public Category(String name) {
      Assert.hasText(name, "Name must not be null or empty!");
   }
}
