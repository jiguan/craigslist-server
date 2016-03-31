package com.guan.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.guan.dto.UserDto;

import lombok.Data;

@Data @Document
public class User {
    @Id
    private ObjectId id;
    private String username, phone, wechat;
    private boolean poster;
    
    public User() {}
    public User(UserDto dto) {
        this.username = dto.getUsername();
        this.phone = dto.getPhone();
        this.wechat = dto.getWechat();
    }

}