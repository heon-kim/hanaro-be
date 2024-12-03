package org.conan.myboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.domain.PageResponseDTO;
import org.conan.myboot.domain.TodoDTO;
import org.conan.myboot.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todo")
public class TodoController{
    private final TodoService service;
    private final TodoService todoService;

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable(name="tno") Integer tno){
        return service.read(tno);
    }
    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> List(PageRequestDTO pageRequestDTO){
        log.info(pageRequestDTO);
        return service.list(pageRequestDTO);
    }
    @PostMapping("/")
    public Map<String, Integer> write(@RequestBody TodoDTO todoDTO){
        log.info("TodoDTO:"+todoDTO);
        Integer tno = service.write(todoDTO);
        return Map.of("TNO", tno);
    }
    @PutMapping("/{tno}")
    public Map<String, String> modify(@PathVariable(name="tno") Integer tno, @RequestBody TodoDTO todoDTO){
        todoDTO.setTno(tno);
        log.info("Modify:"+todoDTO);
        service.modify(todoDTO);
        return Map.of("RESULT", "SUCCESS");
    }
    @DeleteMapping("/{tno}")
    public Map<String, String> remove(@PathVariable(name="tno") Integer tno){
        log.info("Remove:"+tno);
        service.delete(tno);
        return Map.of("RESULT","SUCCESS");
    }
}