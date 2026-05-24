package com.pdgs.taskManager.service;

import com.pdgs.taskManager.domain.CreateTaskRequest;
import com.pdgs.taskManager.domain.entity.Task;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

}
