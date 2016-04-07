package com.guan.domain;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Role> roles = new HashSet<Role>();
    
    public User() {
        roles.add(RoleFactory.getRoleUser());
    }
    public User(User user) {
        this();
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.wechat = user.getWechat();
        this.password = user.getPassword();
        this.poster = user.isPoster();
        this.roles = new HashSet<Role>(user.getRoles());
    }
    public User(UserDto dto) {
        this();
        assert(dto.getId()==null); //this constructor is only for creating a new user
        this.username = dto.getUsername();
        this.phone = dto.getPhone();
        this.wechat = dto.getWechat();
        this.password = dto.getPassword();
    }

}