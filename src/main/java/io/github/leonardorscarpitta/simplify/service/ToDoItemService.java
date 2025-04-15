package io.github.leonardorscarpitta.simplify.service;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoItemService {

    @Autowired
    @Qualifier("toDoItemRepository")
    ToDoItemRepository tdRepository;

    public ToDoItem createTask(ToDoItem todoItem) {
        return tdRepository.save(todoItem);
    }

    public List<ToDoItem> listTasks() {
        return tdRepository.findAll();
    }

    public ToDoItem updateTask(ToDoItem toDoItem) {
        return tdRepository.save(toDoItem);
    }

    public Optional<ToDoItem> searchById(Long id) {
        return tdRepository.findById(id);
    }

    public void deleteTask(Long id) {
        tdRepository.deleteById(id);
    }

    public ToDoItem updateStatus(ToDoItem toDoItem) {
        Boolean modifiedStatus = !toDoItem.getStatus();
        toDoItem.setStatus(modifiedStatus);
        return tdRepository.save(toDoItem);
    }
}
