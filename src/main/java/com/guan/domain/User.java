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
    private String password;
    private boolean poster;
    private Role role;
    
    public User() {}
    public User(UserDto dto) {
        assert(dto.getId()==null); //this constructor is only for creating a new user
        this.username = dto.getUsername();
        this.phone = dto.getPhone();
        this.wechat = dto.getWechat();
        this.password = dto.getPassword();
    }

}