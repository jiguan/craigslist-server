package com.guan.domain;

public class RoleFactory {
    private static final Role ROLE_USER = new Role("USER");
    private static volatile Role ROLE_ADMIN = new Role("ADMIN");
    private RoleFactory() { }
    
    public static Role getRoleUser() {
        return ROLE_USER;
    }
    
    public static Role getRoleAdmin() {
        return ROLE_ADMIN;
    }
}
