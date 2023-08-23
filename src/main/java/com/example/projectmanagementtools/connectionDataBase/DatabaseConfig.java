package com.example.projectmanagementtools.connectionDataBase;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DatabaseConfig {
    @Value("${DB_URL}")
    private String Url;

    @Value("${DB_USERNAME}")
    private String Username;

    @Value("${DB_PASSWORD}")
    private String Password;

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.Url, this.Username, this.Password);
    }
}
