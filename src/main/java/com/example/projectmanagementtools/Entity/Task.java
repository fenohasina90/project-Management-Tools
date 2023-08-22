package com.example.projectmanagementtools.Entity;

import lombok.*;

import java.sql.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Task {
    private int id;
    private String taskName;
    private String description;
    private Date deadline;
    private String taskStatus;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int userId;
    private int projectId;
}
