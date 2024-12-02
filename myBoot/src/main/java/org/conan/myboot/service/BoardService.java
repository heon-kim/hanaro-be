package org.conan.myboot.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.*;
import org.conan.myboot.dao.BoardMapper;
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
        BoardDTO boardDTO = BoardDTO.builder()
                        .title("Test Title1")
                                .content("Test Content1")
                                        .writerEmail("user5@aaa.com").build();
        log.info(dto);
        Board entity = dtoToEntity(dto);
        log.info(entity);
        boardRepository.save(entity);
        return entity.getBno();
    }
    public Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder().email(dto.getWriterEmail()).build();
        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }

    public BoardDTO entityToDto(Board board, Member member, Long replyCount){
        BoardDTO dto = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .replyCount(replyCount.intValue())
                .build();
        return dto;
    }

    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO requestDTO){
        log.info(requestDTO);
        Function<Object[], BoardDTO> fn = (en->entityToDto((Board) en[0], (Member) en[1], (Long) en[2]));
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(requestDTO.getPageable(Sort.by("bno").descending()));



        return new PageResultDTO<>(result, fn);
    }
}
