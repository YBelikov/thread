package com.threadjava.commentReactions;


import com.threadjava.commentReactions.model.CommentReaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CommentReactionRepository extends CrudRepository<CommentReaction, UUID> {
    @Query(" SELECT r "
            + " FROM CommentReaction r"
            + " WHERE r.user.id = :userId AND r.comment.id = :commentId")
    Optional<CommentReaction> getCommentReaction(@Param("userId") UUID userId, @Param("commentId") UUID commentId);
}
