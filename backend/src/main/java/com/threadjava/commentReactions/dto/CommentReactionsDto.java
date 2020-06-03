package com.threadjava.commentReactions.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentReactionsDto {
    private UUID id;
    private Boolean isLike;
}


