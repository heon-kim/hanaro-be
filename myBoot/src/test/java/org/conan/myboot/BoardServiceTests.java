package org.conan.myboot;

import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.BoardDTO;
import org.conan.myboot.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
    @Autowired
    BoardService boardService;
    @Test
    public void write(){
        BoardDTO boardDTO = BoardDTO.builder()
                .title("Test title1")
                .content("Test Content1")
                .writer("user001")
                .build();
        log.info(boardService.write(boardDTO));
    }
}
