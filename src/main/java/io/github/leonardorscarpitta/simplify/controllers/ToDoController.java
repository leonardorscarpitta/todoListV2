package io.github.leonardorscarpitta.simplify.controllers;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.services.impl.ToDoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoItemService toDoItemService;

    public ToDoController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    @GetMapping
    public List<ToDoItem> listTasks() {
        return toDoItemService.listTasks();
    }

    @GetMapping("/{id}")
    public Optional<ToDoItem> searchById(@PathVariable Long id) {
        return toDoItemService.searchById(id);
    }

    @PostMapping
    public ResponseEntity<HashMap<String,Object>> createTask(@RequestBody ToDoItem toDoItem) {
        toDoItemService.createTask(toDoItem);
        HttpStatus httpStatus = HttpStatus.CREATED;
        HashMap<String, Object> response = ManageHttpStatus.manage(httpStatus, "Task criada com sucesso!");
        return ResponseEntity.status(httpStatus).body(response);
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
    public ResponseEntity<HashMap<String,Object>> deleteTask(@PathVariable Long id) {
        toDoItemService.deleteTask(id);
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        HashMap<String, Object> response = ManageHttpStatus.manage(httpStatus, "Task deletada com sucesso!");
        toDoItemService.deleteTask(id);
        return ResponseEntity.status(httpStatus).body(response);
    }
}
