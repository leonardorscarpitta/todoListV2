package io.github.leonardorscarpitta.simplify.repository;

import io.github.leonardorscarpitta.simplify.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
