package org.conan.myboot.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/todo/*")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;
    @GetMapping("/list")
    public void list(Model model){
        List<Todo> tList = todoService.getList();
        model.addAttribute("tList", tList);
        log.info("tList: " + tList);
    }
    @GetMapping("/write")
    public void registerPage(){
        log.info("write");
    }
    @PostMapping("/write")
    public String register(Todo todo, RedirectAttributes rttr) {
        log.info("write: {}", todo);
        todoService.write(todo);
        rttr.addFlashAttribute("result", todo.getTno());
        return "redirect:/todo/list";
    }
    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam("tno") Integer tno, Model model){
        log.info("/read or /write");
        model.addAttribute("todo", todoService.read(tno));
    }
    @PostMapping("/modify")
    public String modify(Todo todo, RedirectAttributes rttr){
        log.info("modify: {}", todo);
        try{
            todoService.modify(todo);
            return "redirect:/todo/list";
        } catch (Exception e){
            return "/todo/modify";
        }
    }
    @PostMapping("/remove")
    public String remove(@RequestParam("tno")Integer tno, RedirectAttributes rttr){
        log.info("remove..........{}", tno);
        try{
            todoService.remove(tno);
        } catch (Exception e){}
        return "redirect:/todo/list";
    }
}
