package org.conan.myboot.dao;

import org.conan.myboot.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
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
