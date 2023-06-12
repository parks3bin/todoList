package com.codestates.todo.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.todo.entity.Todo;
import com.codestates.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        String todoTitle = todo.getTitle().toUpperCase();

        verifyExistTodo(todoTitle);

        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        Todo findTodo = findVerifiedTodo(todo.getId());

        Optional.ofNullable(todo.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.getTodoOrder())
                .ifPresent(todoOrder -> findTodo.setTodoOrder(todoOrder));
        Optional.ofNullable(todo.getCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    public Todo findTodo(long id) {
        return findVerifiedTodoByQuery(id);
    }

    public List<Todo> findTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public void deleteTodo(long id) {
        Todo todo = findVerifiedTodo(id);
        todoRepository.delete(todo);
    }

    public Todo findVerifiedTodo(long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo findTodo = optionalTodo.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));

        return findTodo;
    }

    private void verifyExistTodo(String title) {
        Optional<Todo> todo = todoRepository.findByTitle(title);
        if (todo.isPresent())
            throw new BusinessLogicException(ExceptionCode.TODO_TITLE_EXISTS);
    }

    private Todo findVerifiedTodoByQuery(long id) {
        Optional<Todo> optionalTodo = todoRepository.findByTodo(id);
        Todo findTodo = optionalTodo.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));

        return findTodo;
    }
}


