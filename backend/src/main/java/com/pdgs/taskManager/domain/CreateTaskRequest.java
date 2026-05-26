package com.pdgs.taskManager.domain;

import java.time.LocalDate;

import com.pdgs.taskManager.domain.entity.TaskPriority;

public record CreateTaskRequest( String title, String description, LocalDate due_Date, TaskPriority priority) {}
