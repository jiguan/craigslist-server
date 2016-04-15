package com.guan.domain;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;


@Data
public class Comment {
    private static AtomicInteger seq;
    private int id;
    private float rate = 0f;
    private String comment;
    private String username;
    private String reply;

    public Comment() {
        this.id = seq.incrementAndGet();
    }

}