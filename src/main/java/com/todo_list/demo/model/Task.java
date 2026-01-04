package com.todo_list.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.todo_list.demo.enums.TaskPriority;
import com.todo_list.demo.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Locale;

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

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "created", updatable = false)
    private LocalDate createdDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private TaskStatus taskStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority")
    private TaskPriority taskPriority;

    @ManyToOne(optional = false)
    @JoinColumn(name = "task_group_id")
    @JsonBackReference
    private TaskGroup taskGroup;

}

/* DATA DE CRIAÇÃO DA TAREFA
@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_cadastro", nullable = false, updatable = false) // updatable = false: não poderá ser alterada após inserção
    protected LocalDateTime dataDeCadastro = LocalDateTime.now();
 */
