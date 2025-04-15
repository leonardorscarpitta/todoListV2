package io.github.leonardorscarpitta.simplify.service;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.repository.ToDoItemRepository;
import io.github.leonardorscarpitta.simplify.utils.domain.ExceptionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoItemService {

    @Autowired
    ToDoItemRepository toDoItemRepository;

    public ToDoItem createTask(ToDoItem todoItem) {
        return toDoItemRepository.save(todoItem);
    }

    public List<ToDoItem> listTasks() {
        return toDoItemRepository.findAll();
    }

    public ToDoItem updateTask(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    public Optional<ToDoItem> searchById(Long id) {
        ExceptionHandling.checkForNan(id);
        return toDoItemRepository.findById(id);
    }

    public void deleteTask(Long id) {
        ExceptionHandling.checkForNan(id);
        toDoItemRepository.deleteById(id);
    }

    public ToDoItem updateStatus(ToDoItem toDoItem) {
        toDoItem.changeStatus();
        return toDoItemRepository.save(toDoItem);
    }
}
