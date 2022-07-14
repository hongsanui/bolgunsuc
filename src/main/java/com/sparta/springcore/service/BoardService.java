package com.sparta.springcore.service;

import com.sparta.springcore.dto.BoardRequestDto;
import com.sparta.springcore.model.Board;
import com.sparta.springcore.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository productRepository;
    @Autowired
    public BoardService(BoardRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Board createProduct(BoardRequestDto requestDto, Long userId ) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Board product = new Board(requestDto);

        productRepository.save(product);

        return product;
    }
    @Transactional
    public Long update(Long id, BoardRequestDto requestDto){
        Board board = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다.")

        );
        board.update(requestDto);
        return board.getId();
    }



    // (관리자용) 상품 전체 조회
    public List<Board> getAllProducts() {
        return productRepository.findAll();
    }
}
