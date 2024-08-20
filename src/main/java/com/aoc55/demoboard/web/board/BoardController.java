package com.aoc55.demoboard.web.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


/**
 * Board Controller
 * Created by aoc55.soft@gmail.com
 */

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping
    public String boardList(HttpServletRequest request, Model model){
        model.addAttribute("boardList", boardService.selectAll());
        return "board/board-list";
    }


    @GetMapping("/{boardId}")
    public String boardDetail(HttpServletRequest request, Model model,
                              @PathVariable(name = "boardId") Long boardId){
        model.addAttribute("board", boardService.selectOne(boardId));
        return "board/board-detail";
    }


    @GetMapping("/new")
    public String boardNewPage(){
        return "board/board-new";
    }


    @PostMapping
    public ResponseEntity<String> newBoard(@Valid @ModelAttribute BoardRequest boardRequest, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            StringBuilder errorMsg = new StringBuilder();
            for(FieldError err : bindingResult.getFieldErrors()){
                errorMsg.append(err.getField()).append(" -> ").append(err.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg.toString());
        }
        return ResponseEntity.ok(""+boardService.create(boardRequest));
    }


    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable(name = "boardId") Long boardId, @RequestParam String password){

        log.info("password ={}", password);
        boolean result = boardService.delete(boardId, password);

        if(result){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
