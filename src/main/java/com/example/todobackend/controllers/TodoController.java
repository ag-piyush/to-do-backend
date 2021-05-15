package com.example.todobackend.controllers;

import com.example.todobackend.model.Todo;
import com.example.todobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    /*
        class TodoRepositoryImpl implement TodoRepository
        TodoRepository tR = new TodoRepositoryImpl();
     */

    @Autowired
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return this.todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") String id) {
        return this.todoRepository.findById(id).get();
    }

    @PostMapping
    public Todo saveTodo(@RequestBody Todo todo){
        return this.todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") String id) {
        this.todoRepository.deleteById(id);
    }
}
/* post mapping me path variable
/*
    todoapplication.io    /todo    /5
    todoapplication.io    /user
    baseUrl ^

 */


/*
            /*
    req -> url
    req -> headers
    req -> parameters

    res -> data
    res -> code
    res -> header
 */

/*
    class -> starts with capital
    object/attribute name -> starts with small
    package ->
    starts with small, try to make it one word only
     (model, string, functions) (todoString -> todo ke inside string)
    camelCase
 */
