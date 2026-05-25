package com.pdgs.taskManager.mapper;

import com.pdgs.taskManager.domain.CreateTaskRequest;
import com.pdgs.taskManager.domain.dto.CreateTaskRequestDTO;
import com.pdgs.taskManager.domain.dto.TaskDTO;
import com.pdgs.taskManager.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDTO dto);

    TaskDTO toDto(Task task);

}
