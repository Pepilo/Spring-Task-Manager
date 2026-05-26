package com.pdgs.taskManager.domain.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.pdgs.taskManager.domain.entity.TaskPriority;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskRequestDTO( 
    @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
    @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
    String title,
    @Nullable 
    @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
    String description,
    @Nullable
    @FutureOrPresent(message = ERROR_MESSAGE_DUEDATE_FUTURE)
    LocalDate due_Date,
    @NotNull (message = ERROR_MESSAGE_PRIORITY)
    TaskPriority priority) {

    private static final String ERROR_MESSAGE_TITLE_LENGTH = "Title must be between 1 and 255 characters.";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH = "Description must be less than 1000 characters.";
    private static final String ERROR_MESSAGE_DUEDATE_FUTURE = "Due date must be in the future.";
    private static final String ERROR_MESSAGE_PRIORITY = "Task priority must be provided.";
}
