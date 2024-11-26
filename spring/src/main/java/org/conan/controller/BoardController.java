package org.conan.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.conan.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    @GetMapping("/list")
    public void list(Model model){
        log.info("list");
        model.addAttribute("bList", boardService.getList());
    }
}
