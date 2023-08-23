package com.example.projectmanagementtools.service;

import com.example.projectmanagementtools.entity.Task;
import com.example.projectmanagementtools.repository.TaskDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {this.taskDAO = taskDAO;}

    public Task insert(Task toInsert){
        try{
            this.taskDAO.insert(toInsert);
            return toInsert;
        }catch(SQLException e){
            throw new RuntimeException("Error during the task insertion");
        }
    }

    public List<Task> findAllProject(){
        try{
            return taskDAO.findAll();
        }catch (SQLException e){
            throw new RuntimeException("Error during the all task getting");
        }
    }

    public Optional<Task> findContestById(int id){
        try{
            return taskDAO.findById(id);
        }catch(SQLException e){
            throw new RuntimeException("Error during the task getting by id "+ id);
        }
    }

    public Task updateProject(Task toUpdate){
        try{
            this.taskDAO.update(toUpdate);
            return toUpdate;
        }catch (SQLException e){
            throw new RuntimeException("Error during the task updating");
        }
    }

    public void deleteProject(int id) {
        try {
            taskDAO.delete(id);
        } catch (SQLException e){
            throw new RuntimeException("Error during the task deleting by id "+ id,e);
        }
    }
}
