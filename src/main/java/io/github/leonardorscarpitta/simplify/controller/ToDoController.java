package io.github.leonardorscarpitta.simplify.controller;

import io.github.leonardorscarpitta.simplify.model.ToDoItem;
import io.github.leonardorscarpitta.simplify.dto.ToDoItemDTO;
import io.github.leonardorscarpitta.simplify.service.ToDoItemServiceImpl;
import io.github.leonardorscarpitta.simplify.controller.util.ManageHttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoItemServiceImpl toDoItemServiceImpl;

    public ToDoController(ToDoItemServiceImpl toDoItemServiceImpl) {
        this.toDoItemServiceImpl = toDoItemServiceImpl;
    }

    @Operation(summary = "Listar todas as tarefas")
    @ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso!")
    @GetMapping
    public List<ToDoItemDTO> listTasks() {
        return toDoItemServiceImpl.listTasks();
    }

    @Operation(summary = "Listar tarefa por ID")
    @ApiResponse(responseCode = "200", description = "Tarefa listada com sucesso!")
    @GetMapping("/{id}")
    public Optional<ResponseEntity<ToDoItemDTO>> searchById(@PathVariable Long id) {
        return toDoItemServiceImpl.searchById(id).map(item -> ResponseEntity.ok(new ToDoItemDTO(item)));
    }

    @Operation(summary = "Criar nova tarefa")
    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso!")
    @PostMapping
    public ResponseEntity<HashMap<String,Object>> createTask(@RequestBody ToDoItemDTO toDoItem) {
        toDoItemServiceImpl.createTask(toDoItem);
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
        var updatedData = toDoItemServiceImpl.updateTask(transferredData);
        return new ToDoItemDTO(updatedData);
    }

    @Operation(summary = "Alterar o estado da tarefa (concluída/pendente)")
    @ApiResponse(responseCode = "200", description = "Estado da tarefa alterado com sucesso!")
    @PatchMapping("/{id}")
    public ToDoItemDTO changeStatus(@PathVariable Long id, @RequestBody ToDoItemDTO data) {
        var transferredData = new ToDoItem(data);
        transferredData.setId(id);
        return new ToDoItemDTO(toDoItemServiceImpl.updateStatus(transferredData));
    }

    @Operation(summary = "Deletar uma tarefa")
    @ApiResponse(responseCode = "202", description = "Tarefa excluída com sucesso!")
    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String,Object>> deleteTask(@PathVariable Long id) {
        toDoItemServiceImpl.deleteTask(id);
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        HashMap<String, Object> response = ManageHttpStatus.manage(httpStatus, "Task deletada com sucesso!");
        return ResponseEntity.status(httpStatus).body(response);
    }
}
