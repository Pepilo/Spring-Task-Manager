package com.pdgs.taskManager.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdgs.taskManager.domain.CreateTaskRequest;
import com.pdgs.taskManager.domain.UpdateTaskRequest;
import com.pdgs.taskManager.domain.dto.CreateTaskRequestDTO;
import com.pdgs.taskManager.domain.dto.TaskDTO;
import com.pdgs.taskManager.domain.dto.UpdateTaskRequestDTO;
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

    @PostMapping
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

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
        List<Task> tasks = taskService.getTasks();
        List<TaskDTO> taskDTOs = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDTOs);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TaskDTO> updateTask(
        @PathVariable UUID id,
        @Valid
        @RequestBody
        UpdateTaskRequestDTO updateTaskRequestDTO
    ) {
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDTO);
        Task task = taskService.updateTask(id, updateTaskRequest);
        TaskDTO updateTaskDTO = taskMapper.toDto(task);
        return ResponseEntity.ok(updateTaskDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTask(
        @PathVariable UUID id
    ) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
