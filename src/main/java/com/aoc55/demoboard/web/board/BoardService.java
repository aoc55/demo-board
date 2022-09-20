package com.aoc55.demoboard.web.board;

import com.aoc55.demoboard.domain.board.Board;
import com.aoc55.demoboard.domain.board.BoardRepository;
import com.aoc55.demoboard.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Board Service
 * Created by aoc55.soft@gmail.com
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardResponse> selectAll(){
        return boardRepository.findAll().stream().map(
                board -> MapperUtils.map(board, BoardResponse.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardResponse selectOne(Long boardId){
        return MapperUtils.map(boardRepository.findById(boardId), BoardResponse.class);
    }

    @Transactional
    public Long create(BoardRequest boardRequest){
        Board savedBoard = boardRepository.save(MapperUtils.map(boardRequest, Board.class));
        return savedBoard.getBoardId();
    }
    @Transactional
    public Boolean delete(Long boardId, String password){
        Board board = boardRepository.findById(boardId).orElseThrow(IllegalStateException::new);
        if(board.getPassword().equals(password)){
            boardRepository.deleteById(boardId);
            return true;
        }
        return false;
    }

}
