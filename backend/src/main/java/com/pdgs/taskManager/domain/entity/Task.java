package com.pdgs.taskManager.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @UuidGenerator
    private UUID id;
    private String title;
    private String description;
    private LocalDate due_Date;
    private TaskStatus status;
    private TaskPriority priority;
    private Instant created;
    private Instant updated;

    public Task() {  
    }

    public Task(UUID id, String title, String description, LocalDate due_Date, TaskStatus status, TaskPriority priority, Instant created, Instant updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_Date = due_Date;
        this.status = status;
        this.priority = priority;
        this.created = created;
        this.updated = updated;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return due_Date;
    }

    public void setDueDate(LocalDate due_Date) {
        this.due_Date = due_Date;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Task{" + 
            "id=" + id +
            ", title" + title + '\'' +
            ", description" + description + '\'' +
            ", due_Date=" + due_Date +
            ", status=" + status +
            ", priority=" + priority +
            ", created=" + created +
            ", updated=" + updated +
            '}';
    }
}