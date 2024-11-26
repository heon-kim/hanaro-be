package org.conan.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.conan.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @PostMapping("/write")
    public String register(Board board, RedirectAttributes rttr){
        log.info("write: "+board);
        boardService.write(board);
        rttr.addFlashAttribute("result", board.getBno());
        return "redirect:/board/list";
    }
    @GetMapping("/read")
    public void read(@RequestParam("bno") Integer bno, Model model){
        log.info("/read");
        model.addAttribute("board", boardService.read(bno));
    }
    @PostMapping("/modify")
    public String modify(Board board, RedirectAttributes rttr){
        log.info("modify: "+board);
        if(boardService.modify(board)){
            rttr.addFlashAttribute("result","success");
        }
        return "redirect:/board/list";
    }
    @PostMapping("/remove")
    public String remove(@RequestParam("bno")Integer bno, RedirectAttributes rttr){
        log.info("remove.........."+bno);
        if(boardService.remove(bno)){
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }
}
