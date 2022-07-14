package com.sparta.springcore.dto;

import com.sparta.springcore.model.Board;
import com.sparta.springcore.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String text;
    private User user;
    private Board board;
}
