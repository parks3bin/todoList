package com.codestates.todo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Todo {
    @Id
    private long id;
    private String title;
    private Integer todoOrder;
    private Boolean completed;
}
