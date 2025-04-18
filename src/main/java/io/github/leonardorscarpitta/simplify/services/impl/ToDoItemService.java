package io.github.leonardorscarpitta.simplify.services.impl;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import io.github.leonardorscarpitta.simplify.models.ToDoItemDTO;
import io.github.leonardorscarpitta.simplify.repositories.ToDoItemRepository;
import io.github.leonardorscarpitta.simplify.services.interfaces.ToDoItemInterface;
import io.github.leonardorscarpitta.simplify.utils.domain.ExceptionHandling;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoItemService implements ToDoItemInterface {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public void createTask(ToDoItemDTO todoItemDto) {
        toDoItemRepository.save(new ToDoItem(todoItemDto));
    }

    public List<ToDoItemDTO> listTasks() {
        var toDoItemList = toDoItemRepository.findAll();
        var todoItemDtoList = new ArrayList<ToDoItemDTO>();
        toDoItemList.forEach(item -> todoItemDtoList.add(new ToDoItemDTO(item)));
        return todoItemDtoList;
    }

    public ToDoItem updateTask(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    public Optional<ToDoItem> searchById(Long id) {
        var toDoItem = new ToDoItem();
        toDoItem.setId(id);
        ExceptionHandling.checkForNan(id);
        return toDoItemRepository.findById(toDoItem.getId());
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
