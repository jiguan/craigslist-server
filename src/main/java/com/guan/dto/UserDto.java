package com.guan.dto;

import java.util.HashSet;
import java.util.Set;

import com.guan.domain.User;

import lombok.Data;

@Data
public class UserDto {
    private String id, username, phone, wechat;
    private String password;
    private Set<String> roles = new HashSet<>();
    public UserDto() {}
    public UserDto(User user) {
        this.id = user.getId().toHexString();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.wechat = user.getWechat();
        this.roles = user.getRoles();
    }
}
