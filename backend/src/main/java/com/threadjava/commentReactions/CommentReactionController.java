package com.threadjava.commentReactions;

import com.threadjava.commentReactions.dto.ReceivedCommentReactionDto;
import com.threadjava.commentReactions.dto.ResponseCommentReactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.threadjava.auth.TokenService.getUserId;

@RestController
@RequestMapping("api/commentreaction")

public class CommentReactionController {

    @Autowired
    CommentReactionService commentReactionService;

    @Autowired
    SimpMessagingTemplate template;

    @PutMapping
    Optional<ResponseCommentReactionDto> setCommentReaction(@RequestBody ReceivedCommentReactionDto commentReactionDto) {
        commentReactionDto.setUserId(getUserId());
        var result = commentReactionService.setReaction(commentReactionDto);
        if(result.isPresent() && result.get().getIsLike() && result.get().getUserId() == getUserId()) {
            template.convertAndSend("/topic/like", "Your comment was liked");
        }
        return result;
    }
}
