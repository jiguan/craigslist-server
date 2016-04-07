package com.guan.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Document
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 6229952375506113700L;
    @Id
    private ObjectId id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
    
    Role(String name){
        this.name = name;
    }
    
}
