package com.sparta.springcore.model;

import com.sparta.springcore.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;

    @OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
    List<Comment> comment = new ArrayList<>();



    public Board(BoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.text = requestDto.getText();
        this.user = requestDto.getUser();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.text = requestDto.getText();
        this.user = requestDto.getUser();
    }
}