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
        String sql = "INSERT INTO \"user\" (user_name,email,password,created_at) VALUES (?,?,?,?);";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, toInsert.getUserName());
            preparedStatement.setString(2,toInsert.getEmail());
            preparedStatement.setString(3,toInsert.getPassword());
            preparedStatement.setTimestamp(4,toInsert.getCreatedAt());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM \"user\";";

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");

                User user = new User(id,userName,email,password,createdAt);
                list.add(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<User> findById(int id) throws SQLException {
        String sql = "SELECT * FROM \"user\" WHERE id_user = ?;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int idUser = resultSet.getInt("idUser");
                    String userName = resultSet.getString("userName");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    Timestamp createdAt = resultSet.getTimestamp("createdAt");

                    User user = new User(idUser,userName,email,password,createdAt);
                    return Optional.of(user);
                }
            }

        }
        return Optional.empty();
    }

    @Override
    public void update(User toUpdate) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
