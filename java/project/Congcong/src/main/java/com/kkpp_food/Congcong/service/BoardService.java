package com.kkpp_food.Congcong.service;

import com.kkpp_food.Congcong.domain.Board;
import com.kkpp_food.Congcong.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

//    @RequiredArgsConstructor 어노테이션으로 생략
//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }

    // 게시글 전체목록 조회
    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    // 특정 게시글 조회
    public Board detailBoard(Integer BO_NO) {
        return boardRepository.findById(BO_NO).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
    }

    // 게시글 생성
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    // 게시글 수정
    public Board updateBoard(Integer BO_NO, Board board) {
        Board beforeBoard = boardRepository.findById(BO_NO).orElseThrow(
                () -> new RuntimeException("게시글이 존재하지 않습니다."));
        beforeBoard.setBO_TITLE(board.getBO_TITLE());
        beforeBoard.setBO_CONTENT(board.getBO_CONTENT());
        beforeBoard.setBO_DATE(board.getBO_DATE());

        return boardRepository.save(board);
    }

    // 게시글 삭제
    public void deleteBoard(Integer BO_NO) {
        boardRepository.deleteById(BO_NO);
    }
}
