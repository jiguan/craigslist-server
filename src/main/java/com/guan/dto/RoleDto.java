package com.guan.dto;

import com.guan.domain.Role;

import lombok.Data;

@Data
public class RoleDto {
    private String id;
    private String name;
    public RoleDto() {}
    public RoleDto(Role role) {
        this.id = role.getId().toHexString();
        this.name = role.getName();
    }
    
}
