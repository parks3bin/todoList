package com.codestates.todo.mapper;

import com.codestates.todo.dto.TodoPatchDto;
import com.codestates.todo.dto.TodoPostDto;
import com.codestates.todo.dto.TodoResponseDto;
import com.codestates.todo.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
    List<TodoResponseDto> todoToTodoResponseDtos(List<Todo> todos);
}
