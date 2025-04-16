package io.github.leonardorscarpitta.simplify.repositories;

import io.github.leonardorscarpitta.simplify.models.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
