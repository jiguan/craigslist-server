package com.guan.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

      @Id
      private String id;


}