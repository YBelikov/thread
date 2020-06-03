package com.threadjava.commentReactions.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseCommentReactionDto {
    private UUID id;
    private UUID userId;
    private Boolean isLike;
    private UUID commentId;
}
