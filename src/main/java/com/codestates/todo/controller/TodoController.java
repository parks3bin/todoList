package com.codestates.todo.controller;

import com.codestates.todo.dto.TodoPatchDto;
import com.codestates.todo.dto.TodoPostDto;
import com.codestates.todo.dto.TodoResponseDto;
import com.codestates.todo.entity.Todo;
import com.codestates.todo.mapper.TodoMapper;
import com.codestates.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
@Validated
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        Todo todo = todoService.createTodo(mapper.todoPostDtoToTodo(todoPostDto));

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(todo), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTodo(@PathVariable("id") @Positive long id,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setId(id);
        Todo todo = todoService.updateTodo(mapper.todoPatchDtoToTodo(todoPatchDto));

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(todo), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodo(@PathVariable("id") long id) {
        Todo todo = todoService.findTodo(id);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(todo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoService.findTodos();
        List<TodoResponseDto> response = mapper.todoToTodoResponseDtos(todos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") long id) {
        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
