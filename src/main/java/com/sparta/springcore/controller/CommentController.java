package com.sparta.springcore.controller;

import com.sparta.springcore.dto.CommentRequestDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.model.Board;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.BoardRepository;
import com.sparta.springcore.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BoardRepository boardRepository;

    @PostMapping("/api/board/{id}/comment")
    public String createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id, @ModelAttribute CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        Board board = boardRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        comment.setUser(userDetails.getUser());
        comment.setBoard(board);
        commentRepository.save(comment);
        return "redirect:/api/board/{id}";
    }

    @PutMapping("/api/board/{id}/comment/{commentId}")
    public String editComment(@PathVariable Long commentId, @ModelAttribute CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );

        comment.setText(requestDto.getText());

        commentRepository.save(comment);
        return "redirect:/api/board/{id}";
    }

    @DeleteMapping("/api/board/{id}/comment/{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return "redirect:/api/board/{id}";
    }
}
