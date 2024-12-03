package org.conan.myboot;

import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.domain.TodoDTO;
import org.conan.myboot.repository.TodoRepository;
import org.conan.myboot.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoServiceTest {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testWrite(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("서비스 테스트")
                .writer("tester")
                .dueDate(LocalDate.of(2024,5,4))
                .build();
        Integer tno = todoService.write(todoDTO);
        log.info("TNO:"+tno);
    }

    @Test
    public void testRead(){
        Integer tno = 101;
        TodoDTO todoDTO = todoService.read(tno);
        log.info(todoDTO);
    }

    public void modify(TodoDTO todoDTO){
        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());
        Todo todo = result.orElseThrow();
        todo.setTitle(todoDTO.getTitle());
        todo.setDueDate(todoDTO.getDueDate());
        todo.setComplete(todoDTO.isComplete());
        todoRepository.save(todo);
    }

    public void delete(Integer tno){
        todoRepository.deleteById(tno);
    }
}
