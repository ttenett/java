package com.kkpp_food.Congcong.controller;

import com.kkpp_food.Congcong.domain.Board;
import com.kkpp_food.Congcong.repository.BoardRepository;
import com.kkpp_food.Congcong.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 공통 경로 설정
@RestController
@AllArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<Board> boardList() {
        return boardService.findAllBoards();
    }

    @GetMapping("{/board/{BO_NO}")
    public Board boardDetail (@PathVariable int BO_NO) {
        return boardService.detailBoard(BO_NO);
    }

    @PostMapping("/create/board")
    public Board boardSave(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @PutMapping("/update/{BO_NO}")
    public Board boardUpdate(@RequestBody Board board, @PathVariable int BO_NO) {
        return boardService.updateBoard(BO_NO, board);
    }

    @DeleteMapping("/delete/{BO_NO}")
    public void boardDelete(@PathVariable int BO_NO) {
        boardService.deleteBoard(BO_NO);
    }


}
