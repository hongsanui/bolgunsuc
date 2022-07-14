package com.sparta.springcore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoDto {
    @NotBlank(message = "아이디 미입력")
    @Pattern(regexp="^[a-zA-Z0-9]{3,}$",message = "아이디를 특수문자를 제외한 3자 이상 입력해주세요.")
    private String username;

    @NotBlank(message = "비밀번호 미입력")
    @Pattern(regexp="^[a-zA-Z0-9]{4,}$",message = "비밀번호를 특수문자를 제외한 4자 이상 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호 확인")
    private String checkpw;

    public UserInfoDto() {
    }
}
