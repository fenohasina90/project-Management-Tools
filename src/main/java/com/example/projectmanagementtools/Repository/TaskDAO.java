package com.example.projectmanagementtools.Repository;

import com.example.projectmanagementtools.Entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TaskDAO extends BasisDAO<Task>{

    public TaskDAO(Connection connection) {super(connection);}

    @Override
    public void insert(Task toInsert) throws SQLException {
        String sql = "INSERT INTO \"task\""+
                " (task_name,description,deadline,task_status,created_at,updated_at,created_by,for_project)"+
                        " VALUES (?,?,?,?,?,?);";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, toInsert.getTaskName());
            preparedStatement.setString(2,toInsert.getDescription());
            preparedStatement.setDate(3,toInsert.getDeadline());
            preparedStatement.setString(4,toInsert.getTaskStatus());
            preparedStatement.setTimestamp(5,toInsert.getCreatedAt());
            preparedStatement.setTimestamp(6,toInsert.getUpdatedAt());
            preparedStatement.setInt(7,toInsert.getUserId());
            preparedStatement.setInt(8,toInsert.getProjectId());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("Inserted with success!");
            }
        }
    }

    @Override
    public List<Task> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Task> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void update(Task toUpdate) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
