package com.guan.domain;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import com.guan.dto.PostDto;

import lombok.Data;

@Data
@Document
public class Post {
    @Id
    private ObjectId id;
    private String title, detail;
    private Date timestamp;
    @Indexed
    private String username;
    @Indexed
    private String categoryId;

    public Post() {
        this.timestamp = new Date();
    }

    public Post(PostDto dto) {
        this();
        Assert.hasText(dto.getTitle(), "Title must not be null or empty!");
        Assert.hasText(dto.getDetail(), "Detail must not be null or empty!");
        Assert.hasText(dto.getCategoryId(), "Category must not be null or empty!");

        this.title = dto.getTitle();
        this.detail = dto.getDetail();
        this.categoryId = dto.getCategoryId();
    }

}
