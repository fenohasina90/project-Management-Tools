package com.example.projectmanagementtools.Repository;

import com.example.projectmanagementtools.Entity.Project;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            preparedStatement.setTimestamp(5,toInsert.getUpdatedAt());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("Inserted with success!");
            }
        }
    }

    @Override
    public List<Project> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Project> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void update(Project toUpdate) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
