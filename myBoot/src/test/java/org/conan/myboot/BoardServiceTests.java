package org.conan.myboot;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.*;
import org.conan.myboot.repository.BoardRepository;
import org.conan.myboot.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@SpringBootTest
@Log4j2
public class BoardServiceTests {
    @Autowired
    BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testQuery(){
        Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());
        QBoard qBoard = QBoard.board;
        String keyword = "new";
        BooleanBuilder builder= new BooleanBuilder();
        BooleanExpression expression= qBoard.title.contains(keyword);
        builder.and(expression);
        Page<Board> result = boardRepository.findAll(builder, pageable);
        result.stream().forEach(log::info);
    }
    @Test
    public void testQuery2(){
        Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());
        QBoard qBoard = QBoard.board;
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression exTitle = qBoard.title.contains("1");
        BooleanExpression exContent = qBoard.content.contains("3");
        builder.and(qBoard.bno.gt(200L)).and(exTitle).or(exContent);
        Page<Board> result = boardRepository.findAll(builder, pageable);
        result.stream().forEach(log::info);
    }
    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
        for(BoardDTO boardDTO : result.getDtoList()){
            log.info(boardDTO);
        }
    }
}
