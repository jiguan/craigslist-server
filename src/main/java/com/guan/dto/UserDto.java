package com.guan.dto;

import java.util.HashSet;
import java.util.Set;

import com.guan.domain.Role;
import com.guan.domain.User;

import lombok.Data;

@Data
public class UserDto {
    private String id, username, phone, wechat;
    private String password;
    private boolean poster;
    private Set<RoleDto> roles = new HashSet<>();
    public UserDto() {}
    public UserDto(User user) {
        this.id = user.getId().toHexString();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.wechat = user.getWechat();
        this.poster = user.isPoster();
        for(Role r : user.getRoles()) {
            this.roles.add(new RoleDto(r));
        }
    }
}
