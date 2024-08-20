package com.aoc55.demoboard.domain.board;

import com.aoc55.demoboard.domain.DefaultEntity;
import jakarta.persistence.*;
import lombok.*;


/**
 * Board Entity
 * Created by aoc55.soft@gmail.com
 */

@Entity
@Table(name = "board")
@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Board extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String title;

    private String content;

    private String writer;

    private String password;

}
