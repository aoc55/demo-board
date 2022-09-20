package com.aoc55.demoboard.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Board Repository
 * Created by aoc55.soft@gmail.com
 */
public interface BoardRepository extends JpaRepository<Board, Long> {

}
