package com.example.projectmanagementtools.Repository;

import com.example.projectmanagementtools.Entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO extends BasisDAO<User>{
    public UserDAO (Connection connection){super(connection);}

    @Override
    public void insert(User toInsert) throws SQLException {
        String sql = "INSERT INTO \"user\" (user_name,email,password,created_at) VALUES (?,?,?,?)";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, toInsert.getUserName());
            preparedStatement.setString(2,toInsert.getEmail());
            preparedStatement.setString(3,toInsert.getPassword());
            preparedStatement.setTimestamp(4,toInsert.getCreatedAt());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<User> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void update(User toUpdate) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
