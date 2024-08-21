package com.aoc55.demoboard.domain.board;

import com.aoc55.demoboard.domain.DefaultEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String writer;

    @NotBlank
    private String password;

}
