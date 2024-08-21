package com.aoc55.demoboard.web.board;

import com.aoc55.demoboard.domain.board.Board;
import com.aoc55.demoboard.domain.board.BoardRepository;
import com.aoc55.demoboard.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream().map(b -> MapperUtils.map(b, BoardResponse.class)).toList();
    }

    @Transactional(readOnly = true)
    public BoardResponse selectOne(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(IllegalStateException::new);
        return MapperUtils.map(board, BoardResponse.class);
    }

    @Transactional
    public Long create(BoardRequest boardRequest){
        Board newBoard = MapperUtils.map(boardRequest, Board.class);
        newBoard = boardRepository.save(newBoard);
        log.info("게시글 등록 완료 (boardId={})", newBoard.getBoardId());
        return newBoard.getBoardId();
    }

    @Transactional
    public boolean delete(Long boardId, String password){
        Board board = boardRepository.findById(boardId).orElseThrow(IllegalStateException::new);
        if(checkPassword(board, password)) {
            boardRepository.deleteById(board.getBoardId());
            log.info("게시글 삭제 완료 (boardId={})", boardId);
            return true;
        } else {
            log.warn("게시글 삭제 실패 (boardId={})", boardId);
            return false;
        }
    }

    private boolean checkPassword(Board board, String password) {
        if(board.getPassword().equals(password)) {
            return true;
        } else {
            log.warn("비밀번호 불일치 (boardId={})", board.getBoardId());
            return false;
        }
    }
}
