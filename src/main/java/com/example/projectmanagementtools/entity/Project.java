package com.example.projectmanagementtools.entity;

import lombok.*;

import java.sql.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Project {
    private int id;
    private String projectName;
    private String description;
    private Date startDate;
    private Date endDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
