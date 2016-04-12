package com.guan.domain;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.guan.dto.UserDto;
import com.guan.util.RoleUtil;

import lombok.Data;

@Data @Document
public class User {
    @Id
    private ObjectId id;
    private String username, phone, wechat;
    private String password;
    private Set<String> roles = new HashSet<String>();
    
    public User() {
        roles.add(RoleUtil.USER);
    }
    public User(User user) {
        this();
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.wechat = user.getWechat();
        this.password = user.getPassword();
        this.roles = new HashSet<String>(user.getRoles());
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