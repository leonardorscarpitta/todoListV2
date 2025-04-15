package io.github.leonardorscarpitta.simplify.controllers;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    @Qualifier("toDoItemService")
    ToDoItemService tdService;

    @GetMapping
    public List<ToDoItem> listTasks() {
        return tdService.listTasks();
    }

    @GetMapping("/{id}")
    public Optional<ToDoItem> searchById(@PathVariable Long id) {
        return tdService.searchById(id);
    }

    @PostMapping
    public ToDoItem createTask(@RequestBody ToDoItem toDoItem) {
        return tdService.createTask(toDoItem);
    }

    @PutMapping("/{id}")
    public ToDoItem updateTask(@PathVariable Long id, @RequestBody ToDoItem toDoItem) {
        toDoItem.setId(id);
        return tdService.updateTask(toDoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tdService.deleteTask(id);
    }
}
