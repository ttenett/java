package com.kkpp_food.Congcong.dto;

import com.kkpp_food.Congcong.domain.Board;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private Integer BO_NO;
    private String BO_TITLE;
    private String BO_CONTENT;
    private LocalDate BO_DATE;

    public static BoardDto fromEntity(Board board) {
        return BoardDto.builder()
                .BO_NO(board.getBO_NO())
                .BO_TITLE(board.getBO_TITLE())
                .BO_CONTENT(board.getBO_CONTENT())
                .BO_DATE(board.getBO_DATE())
                .build();
    }

    public Board toEntity() {
        return Board.builder()
                .BO_NO(this.BO_NO)
                .BO_TITLE(this.BO_TITLE)
                .BO_CONTENT(this.BO_CONTENT)
                .BO_DATE(this.BO_DATE)
                .build();
    }
}
