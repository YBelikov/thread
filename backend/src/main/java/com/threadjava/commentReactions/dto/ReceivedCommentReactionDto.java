package com.threadjava.commentReactions.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ReceivedCommentReactionDto {
    private UUID userId;
    private Boolean isLike;
    private UUID commentId;
}
