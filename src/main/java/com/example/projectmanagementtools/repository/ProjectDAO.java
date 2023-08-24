package com.example.projectmanagementtools.repository;

import com.example.projectmanagementtools.entity.Project;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectDAO extends BasisDAO<Project>{

    public ProjectDAO(Connection connection) {super(connection);}

    @Override
    public void insert(Project toInsert) throws SQLException {
        String sql =
                "INSERT INTO \"project\" (project_name,description,start_date,end_date,created_at,updated_at)"+
                        " VALUES (?,?,?,?,?,?);";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, toInsert.getProjectName());
            preparedStatement.setString(2,toInsert.getDescription());
            preparedStatement.setDate(3,toInsert.getStartDate());
            preparedStatement.setDate(4,toInsert.getEndDate());
            preparedStatement.setTimestamp(5,toInsert.getCreatedAt());
            preparedStatement.setTimestamp(6,toInsert.getUpdatedAt());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Project> findAll() throws SQLException {
        List<Project> list = new ArrayList<>();
        String sql = "SELECT * FROM \"project\";";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String nameProject = resultSet.getString(2);
                String Description = resultSet.getString(3);
                Date StartDate = resultSet.getDate(4);
                Date endDate = resultSet.getDate(5);
                Timestamp createdAt = resultSet.getTimestamp(6);
                Timestamp updatedAt = resultSet.getTimestamp(7);

                Project project = new Project(id,nameProject,Description,StartDate,endDate,createdAt,updatedAt);
                list.add(project);
            }
        }
        return list;
    }

    @Override
    public Optional<Project> findById(int id) throws SQLException {
        String sql = "SELECT * FROM \"project\" WHERE id_project = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int idProject = resultSet.getInt(1);
                    String projectName = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    Date startDate = resultSet.getDate(4);
                    Date endDate = resultSet.getDate(5);
                    Timestamp createdAt = resultSet.getTimestamp(6);
                    Timestamp updatedAt = resultSet.getTimestamp(7);

                    Project project = new Project(idProject,projectName,description,startDate,endDate,createdAt,updatedAt);
                    return Optional.of(project);
                }
            }

        }
        return Optional.empty();
    }

    @Override
    public void update(Project toUpdate) throws SQLException {
        String sql = "UPDATE \"project\" SET project_name = ?, description = ?, start_date = ?, end_date = ?,"+
                "created_at = ?,updated_at = ? WHERE id_project = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1,toUpdate.getProjectName());
            preparedStatement.setString(2,toUpdate.getDescription());
            preparedStatement.setDate(3,toUpdate.getStartDate());
            preparedStatement.setDate(4,toUpdate.getEndDate());
            preparedStatement.setTimestamp(5,toUpdate.getCreatedAt());
            preparedStatement.setTimestamp(6,toUpdate.getUpdatedAt());
            preparedStatement.setInt(7,toUpdate.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM  \"project\" WHERE id_project = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }
}
