package org.conan.time;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.conan.mapper.BoardMapper;
import org.conan.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
    @Setter(onMethod_ = {@Autowired})
    private BoardMapper boardMapper;
    @Test
    public void testGetList() {
        boardMapper.getList().forEach(board -> log.info(board));
    }
    @Test
    public void testInsert(){
        Board board = new Board();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        boardMapper.insert(board);
        log.info(board);
    }
    @Test
    public void testInsertSelectKey(){
        Board board = new Board();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        boardMapper.insertSelectKey(board);
        log.info(board);
    }
    @Test
    public void testRead(){
        Board board = boardMapper.read(10);
        log.info(board);
    }
    @Test
    public void increaseHit(){
        boardMapper.increaseHit(10);
    }
    @Test
    public void delete(){
        log.info("UPDATE COUNT: " + boardMapper.delete(12));
    }
    @Test
    public void update(){
        Board board = new Board();
        board.setBno(2);
        board.setTitle("수정한 제목");
        board.setContent("수정한 내용");
        int count = boardMapper.update(board);
        log.info("UPDATE COUNT: " + count);
    }
}
