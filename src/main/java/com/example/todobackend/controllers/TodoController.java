package com.example.todobackend.controllers;

import com.example.todobackend.model.Todo;
import com.example.todobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://to-do-piyush.netlify.app/")
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
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
    public Todo saveTodo(@RequestBody Todo todo) {
        return this.todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") String id) {
        this.todoRepository.deleteById(id);
    }
}
