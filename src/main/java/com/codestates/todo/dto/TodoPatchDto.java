package com.codestates.todo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
public class TodoPatchDto {
    @Setter
    private long id;

    @NotBlank(message = "할 일은 공백이 아니어야 합니다.")
    private String title;

    private Integer todoOrder;
    private Boolean completed;
}
