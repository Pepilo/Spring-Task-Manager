package com.pdgs.taskManager.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.pdgs.taskManager.domain.entity.TaskPriority;
import com.pdgs.taskManager.domain.entity.TaskStatus;

public record TaskDTO(
    UUID id,
    String title,
    String description,
    LocalDate duDate,
    TaskStatus status,
    TaskPriority priority
) {}
