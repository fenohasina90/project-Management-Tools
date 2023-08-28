package com.example.projectmanagementtools.controller;

import com.example.projectmanagementtools.entity.Project;
import com.example.projectmanagementtools.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<Project> getAllProject(){
        return this.projectService.findAllProject();
    }

    @GetMapping("/projects/{id}")
    public Optional<Project> getProjectById(@PathVariable int id){
        return this.projectService.findProjectById(id);
    }

    @PostMapping("/projects")
    public Project insertProject(@RequestBody Project toInsert){
        return this.projectService.insert(toInsert);
    }

    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable int id, @RequestBody Project updateProject) {
        if (updateProject.getId() != id) {
            throw new IllegalArgumentException("The ID provided in the request body does not match the ID in the path.");
        }
        return this.projectService.updateProject(updateProject);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Deleted with success");
    }
}
