package com.example.projectmanagementtools.service;

import com.example.projectmanagementtools.entity.User;
import com.example.projectmanagementtools.repository.UserDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {this.userDAO = userDAO;}
    public User insert(User toInsert){
        try{
            this.userDAO.insert(toInsert);
            return toInsert;
        }catch(SQLException e){
            throw new RuntimeException("Error during the User insertion");
        }
    }

    public List<User> findAllUser(){
        try{
            return userDAO.findAll();
        }catch (SQLException e){
            throw new RuntimeException("Error during the all user getting");
        }
    }

    public Optional<User> findUserById(int id){
        try {
            return userDAO.findById(id);
        }catch (SQLException e){
            throw new RuntimeException("Error during the user getting by id "+ id);
        }
    }

    public User updateUser(User toUpdate){
        try{
            this.userDAO.update(toUpdate);
            return toUpdate;
        }catch (SQLException e){
            throw new RuntimeException("Error during the user updating");
        }
    }

    public void deleteUser(int id){
        try{
            userDAO.delete(id);
        }catch (SQLException e){
            throw new RuntimeException("Error during the user deleting by id "+ id,e);
        }
    }
}
