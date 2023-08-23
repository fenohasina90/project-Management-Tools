package com.example.projectmanagementtools.repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;


public abstract class BasisDAO<T>{
    private Connection connection;
    public BasisDAO(Connection connection) {this.connection = connection;}

    public Connection getConnection() {
        return connection;
    }

    public abstract void insert(T toInsert) throws SQLException;
    public abstract List<T> findAll() throws  SQLException;
    public abstract Optional<T> findById(int id) throws SQLException;
    public abstract void update(T toUpdate) throws SQLException;
    public abstract void delete(int id) throws SQLException;
}
