package com.aoc55.demoboard.web;

import com.aoc55.demoboard.domain.board.Board;
import com.aoc55.demoboard.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 초기 데이터 주입용
 * Created by aoc55.soft@gmail.com
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class InitData {
    private final BoardRepository boardRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        boardRepository.save(Board.builder().title("안녕하세요").content("데모 텍스트1입니다").writer("김익명").password("1234").build());
        boardRepository.save(Board.builder().title("반갑습니다").content("데모 텍스트2입니다").writer("이익명").password("4567").build());
        boardRepository.save(Board.builder().title("어서오세요").content("데모 텍스트3입니다").writer("박익명").password("1234").build());
        log.info("초기 데이터 주입완료");
    }
}
