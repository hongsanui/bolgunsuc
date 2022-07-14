package com.sparta.springcore.dto;

import com.sparta.springcore.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {
    private String title;
    private String text;
    private User user;
}