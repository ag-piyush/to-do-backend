package com.example.todobackend.repository;

import com.example.todobackend.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TodoRepository extends MongoRepository<Todo, String> {
    Optional<Todo> findById(String id);
}
