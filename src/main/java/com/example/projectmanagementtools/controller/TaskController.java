package com.example.projectmanagementtools.controller;

import com.example.projectmanagementtools.entity.Task;
import com.example.projectmanagementtools.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTask(){
        return this.taskService.findAllTask();
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable int id){
        return this.taskService.findTaskById(id);
    }

    @PostMapping("/tasks")
    public Task insertTask(@RequestBody Task toInsert){
        return this.taskService.insert(toInsert);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updateTask) {
        if (updateTask.getId() != id) {
            throw new IllegalArgumentException("The ID provided in the request body does not match the ID in the path.");
        }
        return this.taskService.updateTask(updateTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Deleted with success");
    }
}
