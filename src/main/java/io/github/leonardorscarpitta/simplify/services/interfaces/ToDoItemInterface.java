package io.github.leonardorscarpitta.simplify.services.interfaces;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.models.ToDoItemDTO;

import java.util.List;
import java.util.Optional;

public interface ToDoItemInterface {
    void createTask(ToDoItemDTO todoItemDto);
    List<ToDoItemDTO> listTasks();
    Optional<ToDoItem> searchById(Long id);
    ToDoItem updateTask(ToDoItem todoItem);
    void deleteTask(Long id);
    //ToDoItemDTO updateStatus(ToDoItemDTO todoItemDto);
}
