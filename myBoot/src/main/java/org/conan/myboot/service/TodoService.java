package org.conan.myboot.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class TodoService {
    @Setter(onMethod_=@Autowired)
    TodoRepository todoRepository;


    public List<Todo> getList(){
        log.info("getList............");
        return todoRepository.findAll();
    }
    public void write(Todo todo){
        log.info("write.......{}", todo.getTno());
        Todo newTodo= Todo.builder()
                .title(todo.getTitle())
                .writer(todo.getWriter())
                .dueDate(todo.getDueDate())
                .complete(todo.isComplete())
                .build();
        todoRepository.save(newTodo);
    }
    public Todo read(Integer tno) {
        log.info("get..........{}", tno);
        Todo todo = new Todo();
        Optional<Todo> result = todoRepository.findById(tno);
        if (result.isPresent()) {
            todo = result.get();
        }
        return todo;
    }
    public Todo modify(Todo todo){
        log.info("modify............{}", todo);
        Todo updatedTodo = Todo.builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .writer(todo.getWriter())
                .complete(todo.isComplete())
                .dueDate(todo.getDueDate())
                .build();
        return todoRepository.save(updatedTodo);
    }
    public void remove(Integer tno){
        log.info("remove.......{}", tno);
        todoRepository.deleteById(tno);
    }
}
