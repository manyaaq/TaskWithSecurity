package com.example.demo.service;

import com.example.demo.model.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    Task update(Task task);
    void delete(Long id);
    List<Task> getMyTasks(String username);
}
