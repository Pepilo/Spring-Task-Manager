package com.pdgs.taskManager.domain;

import java.time.LocalDate;

import com.pdgs.taskManager.domain.entity.TaskPriority;
import com.pdgs.taskManager.domain.entity.TaskStatus;

public record UpdateTaskRequest(String title, String description, LocalDate dueDate, TaskStatus status, TaskPriority priority) {}
