package com.example.projectmanagementtools.repository;

import com.example.projectmanagementtools.entity.Task;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskDAO extends BasisDAO<Task>{

    public TaskDAO(Connection connection) {super(connection);}

    @Override
    public void insert(Task toInsert) throws SQLException {
        String sql = "INSERT INTO \"task\""+
                " (task_name,description,deadline,task_status,created_at,updated_at,created_by,for_project)"+
                        " VALUES (?,?,?,?,?,?,?,?);";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, toInsert.getTaskName());
            preparedStatement.setString(2,toInsert.getDescription());
            preparedStatement.setDate(3,toInsert.getDeadline());
            preparedStatement.setString(4,toInsert.getTaskStatus());
            preparedStatement.setTimestamp(5,toInsert.getCreatedAt());
            preparedStatement.setTimestamp(6,toInsert.getUpdatedAt());
            preparedStatement.setInt(7,toInsert.getUserId());
            preparedStatement.setInt(8,toInsert.getProjectId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Task> findAll() throws SQLException {
        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM \"task\";";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String taskName = resultSet.getString(2);
                String description = resultSet.getString(3);
                Date deadline = resultSet.getDate(4);
                String taskStatus = resultSet.getString(5);
                Timestamp createdAt = resultSet.getTimestamp(6);
                Timestamp updatedAt = resultSet.getTimestamp(7);
                int userId = resultSet.getInt(8);
                int projectId = resultSet.getInt(9);

                Task task = new Task(id,taskName,description,deadline,taskStatus,createdAt,updatedAt,userId,projectId);
                list.add(task);
            }
        }
        return list;
    }

    @Override
    public Optional<Task> findById(int id) throws SQLException {
        String sql = "SELECT * FROM \"task\" WHERE id_task = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int idTask = resultSet.getInt(1);
                    String taskName = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    Date deadline = resultSet.getDate(4);
                    String taskStatus = resultSet.getString(5);
                    Timestamp createdAt = resultSet.getTimestamp(6);
                    Timestamp updatedAt = resultSet.getTimestamp(7);
                    int userId = resultSet.getInt(8);
                    int projectId = resultSet.getInt(9);

                    Task task = new Task(idTask,taskName,description,deadline,taskStatus,createdAt,updatedAt,userId,projectId);
                    return Optional.of(task);
                }
            }

        }
        return Optional.empty();
    }

    @Override
    public void update(Task toUpdate) throws SQLException {
        String sql = "UPDATE \"task\" SET task_name = ?, description = ?, deadline = ?, task_status = ?,"+
                "created_at = ?,updated_at = ?, created_by = ?, for_project = ? WHERE id_project = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1,toUpdate.getTaskName());
            preparedStatement.setString(2,toUpdate.getDescription());
            preparedStatement.setDate(3,toUpdate.getDeadline());
            preparedStatement.setString(4,toUpdate.getTaskStatus());
            preparedStatement.setTimestamp(5,toUpdate.getCreatedAt());
            preparedStatement.setTimestamp(6,toUpdate.getUpdatedAt());
            preparedStatement.setInt(7,toUpdate.getUserId());
            preparedStatement.setInt(8,toUpdate.getProjectId());
            preparedStatement.setInt(9,toUpdate.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM  \"task\" WHERE id_task = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }
}
