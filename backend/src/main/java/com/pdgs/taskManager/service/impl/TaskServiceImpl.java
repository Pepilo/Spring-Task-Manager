package com.pdgs.taskManager.service.impl;

import org.springframework.stereotype.Service;

import java.time.Instant;

import com.pdgs.taskManager.domain.CreateTaskRequest;
import com.pdgs.taskManager.domain.entity.Task;
import com.pdgs.taskManager.domain.entity.TaskStatus;
import com.pdgs.taskManager.repository.TaskRepository;
import com.pdgs.taskManager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl( TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();

        Task task = new Task(
            null,
            request.title(),
            request.description(),
            request.dueDate(),
            TaskStatus.OPEN,
            request.priority(),
            now,
            now
        );
        
        return taskRepository.save(task);
    }
}
