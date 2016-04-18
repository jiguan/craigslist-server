package com.guan.dto;

import java.util.Date;

import com.guan.domain.Comment;

import lombok.Data;

@Data
public class CommentDto {
    private String id, comment, username, reply, postId;
    private Date timestamp;
    private float rate = 0f;

    public CommentDto() {}

    public CommentDto(Comment comment) {
        this.id = comment.getId().toHexString();
        this.comment = comment.getComment();
        this.username = comment.getUsername();
        this.rate = comment.getRate();
        this.reply = comment.getReply();
        this.postId = comment.getPostId();
        this.timestamp = comment.getId().getDate();
    }

}
