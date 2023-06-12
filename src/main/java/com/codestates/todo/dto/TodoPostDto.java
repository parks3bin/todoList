package com.codestates.todo.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class TodoPostDto {
    @NotBlank
    private String title;
    private long todoOrder;
    private boolean completed;
}
