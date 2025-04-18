package io.github.leonardorscarpitta.simplify.controllers;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.models.ToDoItemDTO;
import io.github.leonardorscarpitta.simplify.services.impl.ToDoItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Listar todas as tarefas")
    @ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso!")
    @GetMapping
    public List<ToDoItemDTO> listTasks() {
        return toDoItemService.listTasks();
    }

    @Operation(summary = "Listar tarefa por ID")
    @ApiResponse(responseCode = "200", description = "Tarefa listada com sucesso!")
    @GetMapping("/{id}")
    public Optional<ToDoItem> searchById(@PathVariable Long id) {
        return toDoItemService.searchById(id);
    }

    @Operation(summary = "Criar nova tarefa")
    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso!")
    @PostMapping
    public ResponseEntity<HashMap<String,Object>> createTask(@RequestBody ToDoItemDTO toDoItem) {
        toDoItemService.createTask(toDoItem);
        HttpStatus httpStatus = HttpStatus.CREATED;
        HashMap<String, Object> response = ManageHttpStatus.manage(httpStatus, "Task criada com sucesso!");
        return ResponseEntity.status(httpStatus).body(response);
    }

    @Operation(summary = "Atualizar alguma informação da tarefa por ID")
    @ApiResponse(responseCode = "200", description = "Informações atualizadas com sucesso!")
    @PutMapping("/{id}")
    public ToDoItemDTO updateTask(@PathVariable Long id, @RequestBody ToDoItemDTO data) {
        var transferredData = new ToDoItem(data);
        transferredData.setId(id);
        var updatedData = toDoItemService.updateTask(transferredData);
        return new ToDoItemDTO(updatedData);
    }

    @Operation(summary = "Alterar o estado da tarefa (concluída/pendente)")
    @ApiResponse(responseCode = "200", description = "Estado da tarefa alterado com sucesso!")
    @PatchMapping("/{id}")
    public ToDoItemDTO changeStatus(@PathVariable Long id, @RequestBody ToDoItemDTO data) {
        var transferredData = new ToDoItem(data);
        transferredData.setId(id);
        return new ToDoItemDTO(toDoItemService.updateStatus(transferredData));
    }

    @Operation(summary = "Deletar uma tarefa")
    @ApiResponse(responseCode = "202", description = "Tarefa excluída com sucesso!")
    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String,Object>> deleteTask(@PathVariable Long id) {
        toDoItemService.deleteTask(id);
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        HashMap<String, Object> response = ManageHttpStatus.manage(httpStatus, "Task deletada com sucesso!");
        toDoItemService.deleteTask(id);
        return ResponseEntity.status(httpStatus).body(response);
    }
}
