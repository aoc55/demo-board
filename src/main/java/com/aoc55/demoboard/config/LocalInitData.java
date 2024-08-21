package com.aoc55.demoboard.config;

import com.aoc55.demoboard.domain.board.Board;
import com.aoc55.demoboard.domain.board.BoardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Local 개발을 위한 초기 데이터 주입용
 * Created by aoc55.soft@gmail.com
 */

@Slf4j
@Profile("local")
@Component
@RequiredArgsConstructor
public class LocalInitData {

    private final BoardRepository boardRepository;

    @PostConstruct
    void init() {
        injectTestDataToDB();
    }

    private void injectTestDataToDB(){
        boardRepository.save(Board.builder().title("안녕하세요").content("데모 텍스트1입니다").writer("김익명").password("1234").build());
        boardRepository.save(Board.builder().title("반갑습니다").content("데모 텍스트2입니다").writer("이익명").password("4567").build());
        boardRepository.save(Board.builder().title("어서오세요").content("데모 텍스트3입니다").writer("박익명").password("1234").build());
        log.info("로컬용 초기 데이터 주입완료");
    }

}
