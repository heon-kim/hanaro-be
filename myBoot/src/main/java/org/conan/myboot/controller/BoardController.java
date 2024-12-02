package org.conan.myboot.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list............");
        log.info(boardService.getList(pageRequestDTO));
        model.addAttribute("bList", boardService.getList(pageRequestDTO));
    }
}