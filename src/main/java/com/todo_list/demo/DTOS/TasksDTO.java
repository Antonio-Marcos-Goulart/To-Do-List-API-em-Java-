package com.todo_list.demo.DTOS;

import com.todo_list.demo.enums.TaskPriority;
import com.todo_list.demo.enums.TaskStatus;
import com.todo_list.demo.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TasksDTO {

    private Long taskId;
    private String taskTitle;
    private String taskDescription;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private Long taskGroupId;
    private LocalDate createDate;

    public TasksDTO(Task task) {
        this.taskId = task.getTaskId();
        this.taskTitle = task.getTaskTitle();
        this.taskDescription = task.getTaskDescription();
        this.taskStatus = task.getTaskStatus();
        this.taskPriority = task.getTaskPriority();
        this.createDate = task.getCreatedDate();

        if (task.getTaskGroup() != null) {
            this.taskGroupId = task.getTaskGroup().getTaskgroupId();
        }
    }
}
