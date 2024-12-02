package org.conan.myboot.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Board;
import org.conan.myboot.dao.BoardMapper;
import org.conan.myboot.domain.BoardDTO;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.domain.PageResultDTO;
import org.conan.myboot.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardService{
    private final BoardRepository boardRepository;
    public Long write(BoardDTO dto){
        log.info("DTO------------------");
        log.info(dto);
        Board entity = dtoToEntity(dto);
        log.info(entity);
        boardRepository.save(entity);
        return entity.getBno();
    }
    public Board dtoToEntity(BoardDTO dto){
        Board entity = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .hit(dto.getHit())
                .build();
        return entity;
    }

    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO){
        Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
        Page<Board> result = boardRepository.findAll(pageable);
        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }

    public BoardDTO entityToDto(Board entity){
        BoardDTO dto = BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate().atStartOfDay())
                .hit(entity.getHit())
                .build();
        return dto;
    }
}


//@Log4j2
//@Service
//public class BoardService {
//    @Setter(onMethod_=@Autowired)
//    private BoardMapper boardMapper;
//
//    public List<Board> getList(){
//        log.info("getList............");
//        List<Board> list = boardMapper.getList();
//        return list != null ? list : List.of();
//    }
//    public void write(Board board){
//        log.info("write.......{}", board.getBno());
//        boardMapper.insertSelectKey(board);
//    }
//    public Board read(Integer bno){
//        log.info("get..........{}", bno);
//        return boardMapper.read(bno);
//    }
//    public boolean modify(Board board){
//        log.info("modify............{}", board);
//        return boardMapper.update(board)==1;
//    }
//    public boolean remove(Integer bno){
//        log.info("remove.......{}", bno);
//        return boardMapper.delete(bno)==1;
//    }
//}
