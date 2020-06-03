package com.threadjava.commentReactions.model;


import com.threadjava.comment.model.Comment;
import com.threadjava.db.BaseEntity;
import com.threadjava.users.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "comment_reactions")
public class CommentReaction extends BaseEntity {
    @Column(name = "is_like")
    private Boolean isLike;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
