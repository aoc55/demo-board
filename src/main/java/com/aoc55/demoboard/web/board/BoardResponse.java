package com.aoc55.demoboard.web.board;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Board Response
 * Created by aoc55.soft@gmail.com
 */

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class BoardResponse {

    private Long boardId;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;

}
