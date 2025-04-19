package io.github.leonardorscarpitta.simplify.dto;

import io.github.leonardorscarpitta.simplify.model.ToDoItem;

public record ToDoItemDTO(
        String name,
        String description,
        Boolean status,
        Short priority
) {
    public ToDoItemDTO(ToDoItem item) {
        this(item.getName(), item.getDescription(), item.getStatus(), item.getPriority());
    }
}
