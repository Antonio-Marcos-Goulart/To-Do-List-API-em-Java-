package com.todo_list.demo.service;

import com.todo_list.demo.DTOS.TasksDTO;
import com.todo_list.demo.model.Task;
import com.todo_list.demo.model.TaskGroup;
import com.todo_list.demo.repository.TaskGroupRepository;
import com.todo_list.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskGroupRepository taskGroupRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskGroupRepository taskGroupRepository) {
        this.taskRepository = taskRepository;
        this.taskGroupRepository = taskGroupRepository;
    }

    public Task createTask(TasksDTO dto) {
        Task task = new Task();
        task.setTaskTitle(dto.getTaskTitle());
        task.setTaskDescription(dto.getTaskDescription());
        task.setTaskStatus(dto.getTaskStatus());
        task.setTaskPriority(dto.getTaskPriority());

        if (dto.getTaskGroupId() == null) {
            throw new IllegalArgumentException("TaskGroupId is required");
        }
        TaskGroup group = taskGroupRepository.findById(dto.getTaskGroupId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "TaskGroup not found with id " + dto.getTaskGroupId()
                ));
        task.setTaskGroup(group);
        return taskRepository.save(task);
    }


    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + id));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> searchTask(Long id, String title) {
        if (id != null) {
            return taskRepository.findById(id)
                    .map(List::of)
                    .orElse(List.of());
        }
        if (title != null && !title.isBlank()) {
            return taskRepository.findByTaskTitleContainingIgnoreCase(title);
        }
        return List.of();
    }

    public Task updateTask(Long id, TasksDTO dto) {
        Task existingTask = getTaskById(id);

        if (dto.getTaskTitle() != null) {
            if (dto.getTaskTitle().length() < 3) {
                throw new IllegalArgumentException("The task title must have at least 3 characters");
            }
            existingTask.setTaskTitle(dto.getTaskTitle());
        }

        if (dto.getTaskDescription() != null) {
            existingTask.setTaskDescription(dto.getTaskDescription());
        }

        if (dto.getTaskStatus() != null) {
            existingTask.setTaskStatus(dto.getTaskStatus());
        }

        if (dto.getTaskPriority() != null) {
            existingTask.setTaskPriority(dto.getTaskPriority());
        }

        if (dto.getTaskGroupId() != null) {
            TaskGroup group = taskGroupRepository.findById(dto.getTaskGroupId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Task Group not found with id " + dto.getTaskGroupId()
                    ));
            existingTask.setTaskGroup(group);
        }
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }

    private void validateTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        if (task.getTaskTitle() == null || task.getTaskTitle().length() < 3) {
            throw new IllegalArgumentException("The task title must have at least 3 characters");
        }

        if (task.getTaskStatus() == null) {
            throw new IllegalArgumentException("The task status cannot be null");
        }

        if (task.getTaskPriority() == null) {
            throw new IllegalArgumentException("The task priority cannot be null");
        }
    }
}
