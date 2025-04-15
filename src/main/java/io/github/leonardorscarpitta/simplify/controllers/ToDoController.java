package io.github.leonardorscarpitta.simplify.controllers;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    ToDoItemService toDoItemService;

    @GetMapping
    public List<ToDoItem> listTasks() {
        return toDoItemService.listTasks();
    }

    @GetMapping("/{id}")
    public Optional<ToDoItem> searchById(@PathVariable Long id) {
        return toDoItemService.searchById(id);
    }

    @PostMapping
    public ToDoItem createTask(@RequestBody ToDoItem toDoItem) {
        return toDoItemService.createTask(toDoItem);
    }

    // FIXME: Incrementar uma forma de fazer com que não seja necessário passar o corpo da tarefa, mas sim somente o ID
    @PutMapping("/{id}")
    public ToDoItem updateTask(@PathVariable Long id, @RequestBody ToDoItem toDoItem) {
        toDoItem.setId(id);
        return toDoItemService.updateTask(toDoItem);
    }

    @PatchMapping("/{id}")
    public ToDoItem changeStatus(@PathVariable Long id, @RequestBody ToDoItem toDoItem) {
        toDoItem.setId(id);
        return toDoItemService.updateStatus(toDoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        toDoItemService.deleteTask(id);
    }
}
