package io.github.leonardorscarpitta.simplify.services.interfaces;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;

import java.util.List;
import java.util.Optional;

public interface ToDoItemInterface {
    void deleteTask(Long id);
    List<ToDoItem> listTasks();
    void createTask(ToDoItem todoItem);
    Optional<ToDoItem> searchById(Long id);
    ToDoItem updateTask(ToDoItem toDoItem);
    ToDoItem updateStatus(ToDoItem toDoItem);
}
