package com.todo_list.demo.controller;

import com.todo_list.demo.DTOS.TasksDTO;
import com.todo_list.demo.model.Task;
import com.todo_list.demo.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "Create task", description = "Create task")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TasksDTO dto) {
        Task saved = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update task by id", description = "Update an existing task by its id")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TasksDTO dto) {
        Task updatedTask = taskService.updateTask(id, dto);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/all_tasks")
    @Operation(summary = "List all tasks", description = "List all tasks")
    public List<TasksDTO> getAllTasks(){
        return taskService.getAllTasks().stream().map(TasksDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete tasks by Id", description = "Delete tasks by Id")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Search task by Id", description = "Search tasks by Id")
    public ResponseEntity<TasksDTO> getTaskById(@PathVariable Long id) {
        Task  task = taskService.getTaskById(id);
        return ResponseEntity.ok(new TasksDTO(task));
    }

    @GetMapping("/search")
    @Operation(summary = "Search task by title and Id", description = "Search tasks by title and Id")
    public ResponseEntity<List<Task>> searchTasks(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String title) {
        return ResponseEntity.ok(taskService.searchTask(id, title));
    }
}
