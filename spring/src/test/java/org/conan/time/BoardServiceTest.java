package org.conan.time;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.conan.mapper.BoardMapper;
import org.conan.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
    @Setter(onMethod_ = {@Autowired})
    private BoardService boardService;

    @Test
    public void testExist() {
        log.info(boardService);
        assertNotNull(boardService);
    }

    @Test
    public void testGetList(){
        boardService.getList().forEach(board->log.info(board));
    }

    @Test
    public void testWrite(){
        Board board = new Board();
        board.setTitle("새글 from Service");
        board.setContent("새 내용 내용 내용 from Service");
        board.setWriter("newbie");
        boardService.write(board);
        log.info("생성된 게시물의 번호: "+board.getBno());
    }

    @Test
    public void testRead(){
        log.info(boardService.read(6).getTitle());
    }

    @Test
    public void testDelete(){
        log.info("REMOVE RESULT: "+ boardService.remove(6));
    }

    @Test
    public  void testUpdate(){
        Board board = boardService.read(7);
        if(board==null){return;}
        board.setTitle("제목 수정 from Service");
        log.info("MODIFY RESULT: "+boardService.modify(board));
    }
}
