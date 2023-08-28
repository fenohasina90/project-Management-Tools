package com.example.projectmanagementtools.repository;

import com.example.projectmanagementtools.entity.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DoDAO extends BasisDAO<Do>{

    public DoDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void insert(Do toInsert) throws SQLException {
        String sql = "INSERT INTO \"do\" (id_user, id_project) VALUES(?,?);";
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, toInsert.getUserId());
            preparedStatement.setInt(2,toInsert.getProjectId());
            preparedStatement.executeUpdate();
        }
    }


    @Override
    public List findAll() throws SQLException {
        List<Do> list = new ArrayList<>();
        String sql = "SELECT * FROM \"do\";";

        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int idUser = resultSet.getInt(2);
                int idProject = resultSet.getInt(3);

                Do ado = new Do(id,idUser,idProject);
                list.add(ado);
            }
        }
        return list;
    }

    @Override
    public Optional<Do> findById(int id) throws SQLException {
        String sql = "SELECT * FROM \"do\" WHERE id_do = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int idDo = resultSet.getInt(1);
                    int idUser = resultSet.getInt(2);
                    int idProject = resultSet.getInt(3);

                    Do ado = new Do(idDo,idUser,idProject);
                    return Optional.of(ado);
                }
            }

        }
        return Optional.empty();
    }

    @Override
    public void update(Do toUpdate) throws SQLException {
        String sql = "UPDATE \"do\" SET id_user = ?, id_project = ? WHERE id_do = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,toUpdate.getUserId());
            preparedStatement.setInt(2,toUpdate.getProjectId());
            preparedStatement.setInt(3,toUpdate.getIdDo());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM  \"do\" WHERE id_do = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }
}
