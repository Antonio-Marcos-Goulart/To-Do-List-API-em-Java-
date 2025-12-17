package com.todo_list.demo.model;

import com.todo_list.demo.enums.TaskPriority;
import com.todo_list.demo.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotEmpty
    @Size(min = 3, max = 100, message = "The task title must be between 3 and 100 characters")
    @Column(name = "task_title")
    private String taskTitle;

    @NotEmpty
    @Size(min = 3, max = 100, message = "The task description must be between 3 and 100 characters")
    @Column(name = "task_description")
    private String taskDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private TaskStatus taskStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority")
    private TaskPriority taskPriority;

}
