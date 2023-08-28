package com.example.projectmanagementtools.service;

import com.example.projectmanagementtools.entity.Do;
import com.example.projectmanagementtools.repository.DoDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DoService {
    private DoDAO doDAO;

    public DoService(DoDAO doDAO) {
        this.doDAO = doDAO;
    }

    public Do insert(Do toInsert){
        try{
            this.doDAO.insert(toInsert);
            return toInsert;
        }catch(SQLException e){
            throw new RuntimeException("Error during the User and project relation insertion");
        }
    }

    public List<Do> findAllDoRelation(){
        try{
            return doDAO.findAll();
        }catch (SQLException e){
            throw new RuntimeException("Error during the all user and project relation getting");
        }
    }

    public Optional<Do> findDoRelationById(int id){
        try {
            return doDAO.findById(id);
        }catch (SQLException e){
            throw new RuntimeException("Error during the user and project relation getting by id "+ id);
        }
    }

    public Do updateDoRelation(Do toUpdate){
        try{
            this.doDAO.update(toUpdate);
            return toUpdate;
        }catch (SQLException e){
            throw new RuntimeException("Error during the user and project relation updating");
        }
    }

    public void deleteDoRelation(int id){
        try{
            doDAO.delete(id);
        }catch (SQLException e){
            throw new RuntimeException("Error during the user and project relation deleting by id "+ id,e);
        }
    }
}
