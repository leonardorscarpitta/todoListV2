package io.github.leonardorscarpitta.simplify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean status;
    private Short priority;

    public ToDoItem(ToDoItemDTO todoItem) {
        this.name = todoItem.name();
        this.description = todoItem.description();
        this.status = todoItem.status();
        this.priority = todoItem.priority();
    }

    public void changeStatus() {
        status = !status;
    }
}
