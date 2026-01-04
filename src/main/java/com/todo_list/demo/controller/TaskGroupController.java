package com.todo_list.demo.controller;

import com.todo_list.demo.DTOS.TaskGroupDTO;
import com.todo_list.demo.model.TaskGroup;
import com.todo_list.demo.service.TaskGroupService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
public class TaskGroupController {

    private final TaskGroupService taskGroupService;

    public TaskGroupController(TaskGroupService taskGroupService) {
        this.taskGroupService = taskGroupService;
    }

    @PostMapping
    @Operation(summary = "Create Group", description = "Create Group'")
    public ResponseEntity<TaskGroup> createTaskGroup(@Valid @RequestBody TaskGroupDTO dto) {
        TaskGroup saved = taskGroupService.createTaskGroup(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update group by id", description = "Update an existing group by its id")
    public ResponseEntity<TaskGroup> updateTaskGroup(
            @PathVariable Long id,
            @Valid @RequestBody TaskGroupDTO dto) {
        TaskGroup updateGroup = taskGroupService.updateTaskGroup(id, dto);
        return ResponseEntity.ok(updateGroup);
    }

    @GetMapping("/all_groups")
    @Operation(summary = "List all groups", description = "List all groups")
    public List<TaskGroupDTO> getAllGroups(){
        return taskGroupService.getAllGroups().stream().map(TaskGroupDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Search group by id", description = "Search group by Id")
    public ResponseEntity<TaskGroupDTO> getTaskGroupById(@PathVariable Long id) {
        TaskGroup group = taskGroupService.getGroupById(id);
        return ResponseEntity.ok(new TaskGroupDTO(group));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete group by id", description = "Delete group by Id")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        taskGroupService.deleteTaskGroup(id);
        return ResponseEntity.noContent().build(); // no response - no content
    }



}
