package com.aoc55.demoboard.web.board;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


/**
 * Board Request
 * Created by aoc55.soft@gmail.com
 */

@Getter @Setter
public class BoardRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String writer;

    @Min(value = 4)
    private String password;

}
