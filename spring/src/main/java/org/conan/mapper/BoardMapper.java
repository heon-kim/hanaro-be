package org.conan.mapper;

import org.apache.ibatis.annotations.Select;
import org.conan.domain.Board;

import java.util.List;

public interface BoardMapper {
//    @Select("SELECT * FROM BOARD WHERE BNO > 0")
    public List<Board> getList();
    public int insert(Board board);
    public int insertSelectKey(Board board);
    public Board read(int bno);
    public int increaseHit(int bno);
    public int delete(int bno);
    public int update(Board board);
}
