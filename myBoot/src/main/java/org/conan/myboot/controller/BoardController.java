//package org.conan.myboot.controller;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.conan.myboot.domain.Board;
//import org.conan.myboot.service.BoardService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//
//@Controller
//@Log4j2
//@RequestMapping("/board/*")
//@AllArgsConstructor
//public class BoardController {
//    private BoardService boardService;
//    @GetMapping("/list")
//    public void list(Model model){
//        List<Board> bList = boardService.getList();
//        model.addAttribute("bList", bList);
//        log.info("bList: " + bList);
//    }
//    @GetMapping("/write")
//    public void registerPage(){
//        log.info("write");
//    }
//    @PostMapping("/write")
//    public String register(Board board, RedirectAttributes rttr){
//        log.info("write: {}", board);
//        boardService.write(board);
//        rttr.addFlashAttribute("result", board.getBno());
//        return "redirect:/board/list";
//    }
//    @GetMapping({"/read", "/modify"})
//    public void read(@RequestParam("bno") Integer bno, Model model){
//        log.info("/read or /write");
//        model.addAttribute("board", boardService.read(bno));
//    }
//    @PostMapping("/modify")
//    public String modify(Board board, RedirectAttributes rttr){
//        log.info("modify: {}", board);
//        if(boardService.modify(board)){
//            rttr.addFlashAttribute("result","success");
//            return "redirect:/board/list";
//        }
//        return "/board/modify";
//    }
//    @PostMapping("/remove")
//    public String remove(@RequestParam("bno")Integer bno, RedirectAttributes rttr){
//        log.info("remove..........{}", bno);
//        if(boardService.remove(bno)){
//            rttr.addFlashAttribute("result", "success");
//        }
//        return "redirect:/board/list";
//    }
//}
