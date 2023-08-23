package com.example.projectmanagementtools.entity;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User{
    private int id;
    private String userName;
    private String email;
    private String password;
    private Timestamp createdAt;
}
