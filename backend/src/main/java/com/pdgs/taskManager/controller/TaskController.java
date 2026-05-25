package com.pdgs.taskManager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdgs.taskManager.domain.CreateTaskRequest;
import com.pdgs.taskManager.domain.dto.CreateTaskRequestDTO;
import com.pdgs.taskManager.domain.dto.TaskDTO;
import com.pdgs.taskManager.domain.entity.Task;
import com.pdgs.taskManager.mapper.TaskMapper;
import com.pdgs.taskManager.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController (TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    public ResponseEntity<TaskDTO> createTask(
        @Valid
        @RequestBody
        CreateTaskRequestDTO createTaskRequestDTO
    ) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDTO);
        Task task = taskService.createTask(createTaskRequest);
        TaskDTO createTaskDTO = taskMapper.toDto(task);
        return new ResponseEntity<>(createTaskDTO, HttpStatus.CREATED);
    }
}
