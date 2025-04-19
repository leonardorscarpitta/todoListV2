package io.github.leonardorscarpitta.simplify.service;

import io.github.leonardorscarpitta.simplify.model.ToDoItem;
import io.github.leonardorscarpitta.simplify.dto.ToDoItemDTO;
import io.github.leonardorscarpitta.simplify.repository.ToDoItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemServiceImpl(ToDoItemRepository toDoItemRepository) {
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
        return toDoItemRepository.findById(toDoItem.getId());
    }

    public void deleteTask(Long id) {
        toDoItemRepository.deleteById(id);
    }

    public ToDoItem updateStatus(ToDoItem toDoItem) {
        toDoItem.changeStatus();
        return toDoItemRepository.save(toDoItem);
    }
}
