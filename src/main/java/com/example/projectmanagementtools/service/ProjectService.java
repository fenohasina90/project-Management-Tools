package com.example.projectmanagementtools.service;

import com.example.projectmanagementtools.entity.Project;
import com.example.projectmanagementtools.repository.ProjectDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO){this.projectDAO = projectDAO;}

    public Project insert(Project toInsert){
        try{
            this.projectDAO.insert(toInsert);
            return toInsert;
        }catch(SQLException e){
            throw new RuntimeException("Error during the project insertion");
        }
    }

    public List<Project> findAllProject(){
        try{
            return projectDAO.findAll();
        }catch (SQLException e){
            throw new RuntimeException("Error during the all project getting");
        }
    }

    public Optional<Project> findProjectById(int id){
        try{
            return projectDAO.findById(id);
        }catch(SQLException e){
            throw new RuntimeException("Error during the project getting by id "+ id);
        }
    }

    public Project updateProject(Project toUpdate){
        try{
            this.projectDAO.update(toUpdate);
            return toUpdate;
        }catch (SQLException e){
            throw new RuntimeException("Error during the project updating");
        }
    }

    public void deleteProject(int id) {
        try {
            projectDAO.delete(id);
        } catch (SQLException e){
            throw new RuntimeException("Error during the project deleting by id "+ id,e);
        }
    }
}
