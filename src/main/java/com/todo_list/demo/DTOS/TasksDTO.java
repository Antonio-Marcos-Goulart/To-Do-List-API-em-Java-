package com.todo_list.demo.DTOS;

import com.todo_list.demo.enums.TaskPriority;
import com.todo_list.demo.enums.TaskStatus;
import com.todo_list.demo.model.Task;

public class TasksDTO {
    private Long taskId;
    private String taskTitle;
    private String taskDescription;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;

    public TasksDTO(Task task) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
    }
}
