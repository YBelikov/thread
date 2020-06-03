package com.threadjava.commentReactions;

import com.threadjava.commentReactions.dto.ReceivedCommentReactionDto;
import com.threadjava.commentReactions.dto.ResponseCommentReactionDto;
import com.threadjava.commentReactions.model.CommentReaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentReactionMapper {

    CommentReactionMapper MAPPER = Mappers.getMapper(CommentReactionMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "comment.id", target = "commentId")
    ResponseCommentReactionDto reactionToCommentReactionDto(CommentReaction reaction);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "commentId", target = "post.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CommentReaction dtoToCommentReaction(ReceivedCommentReactionDto commentReactionDto);

}
