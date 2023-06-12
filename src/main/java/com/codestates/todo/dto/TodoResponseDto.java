package com.codestates.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoResponseDto {
    private long id;
    private String title;
    private Integer todoOrder;
    private Boolean completed;
}
