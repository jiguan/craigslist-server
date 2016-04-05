package com.guan.dto;

import com.guan.domain.User;

import lombok.Data;

@Data
public class UserDto {
    private String id, username, phone, wechat;
    private String password;
    private boolean poster;
    public UserDto() {}
    public UserDto(User user) {
        this.id = user.getId().toHexString();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.wechat = user.getWechat();
        this.poster = user.isPoster();
    }
}
