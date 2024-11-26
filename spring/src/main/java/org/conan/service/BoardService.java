package org.conan.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.conan.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class BoardService {
    @Setter(onMethod_=@Autowired)
    private BoardMapper boardMapper;

    public List<Board> getList(){
        log.info("getList............");
        return boardMapper.getList();
    }
    public void write(Board board){
        log.info("write......."+board.getBno());
        boardMapper.insertSelectKey(board);
    }
    public Board read(Integer bno){
        log.info("get.........."+bno);
        return boardMapper.read(bno);
    }
    public boolean modify(Board board){
        log.info("modify............"+board);
        return boardMapper.update(board)==1;
    }
    public boolean remove(Integer bno){
        log.info("remove......."+bno);
        return boardMapper.delete(bno)==1;
    }
}
