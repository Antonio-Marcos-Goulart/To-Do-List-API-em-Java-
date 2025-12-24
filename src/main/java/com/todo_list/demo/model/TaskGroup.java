package com.todo_list.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "task_group")
public class TaskGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskgroupId;

    @NotEmpty
    @Size(min = 3, max = 100, message = "The task group title must be between 3 and 100 characters")
    @Column(name = "taskgroup_title")
    private String taskGroupTitle;

    @OneToMany(mappedBy = "taskGroup",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();
}
