package io.github.leonardorscarpitta.simplify.service;

import io.github.leonardorscarpitta.simplify.model.ToDoItem;
import io.github.leonardorscarpitta.simplify.dto.ToDoItemDTO;

import java.util.List;
import java.util.Optional;

public interface ToDoItemService {
    void createTask(ToDoItemDTO todoItemDto);
    List<ToDoItemDTO> listTasks();
    Optional<ToDoItem> searchById(Long id);
    ToDoItem updateTask(ToDoItem todoItem);
    void deleteTask(Long id);
    //ToDoItemDTO updateStatus(ToDoItemDTO todoItemDto);
}
