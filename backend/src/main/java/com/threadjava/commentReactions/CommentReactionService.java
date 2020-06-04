package com.threadjava.commentReactions;

import com.threadjava.commentReactions.dto.ReceivedCommentReactionDto;
import com.threadjava.commentReactions.dto.ResponseCommentReactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommentReactionService {

    @Autowired
    private CommentReactionRepository commentReactionsRepository;

    public Optional<ResponseCommentReactionDto> setReaction(ReceivedCommentReactionDto reactionDto) {
        var commentReaction = commentReactionsRepository.getCommentReaction(reactionDto.getUserId(), reactionDto.getCommentId());
        if (commentReaction.isPresent()) {
            var reaction = commentReaction.get();
            if (reaction.getIsLike() == reactionDto.getIsLike()) {
                commentReactionsRepository.deleteById(reaction.getId());
                return Optional.empty();
            }
            reaction.setIsLike(reactionDto.getIsLike());
            var result = commentReactionsRepository.save(reaction);
            return Optional.of(CommentReactionMapper.MAPPER.reactionToCommentReactionDto(result));

        }
        var result  = commentReactionsRepository.save(CommentReactionMapper.MAPPER.dtoToCommentReaction(reactionDto));
        return Optional.of(CommentReactionMapper.MAPPER.reactionToCommentReactionDto(result));
    }
}
