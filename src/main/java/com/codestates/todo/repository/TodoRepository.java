package com.codestates.todo.repository;

import com.codestates.todo.entity.Todo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Optional<Todo> findByTitle(String title);

    @Query("SELECT * FROM TODO WHERE ID = :id")
    Optional<Todo> findByTodo(Long id);
}
