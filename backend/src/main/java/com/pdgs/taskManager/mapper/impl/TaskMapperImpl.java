package com.pdgs.taskManager.mapper.impl;

import org.springframework.stereotype.Component;

import com.pdgs.taskManager.domain.CreateTaskRequest;
import com.pdgs.taskManager.domain.dto.CreateTaskRequestDTO;
import com.pdgs.taskManager.domain.dto.TaskDTO;
import com.pdgs.taskManager.domain.entity.Task;
import com.pdgs.taskManager.mapper.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper{

    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDTO dto) {
        return new CreateTaskRequest(
            dto.title(),
            dto.description(),
            dto.dueDate(),
            dto.priority()
        );
    };

    @Override
     public TaskDTO toDto(Task task) {
        return new TaskDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getStatus(),
            task.getPriority()
        );
     };

}
