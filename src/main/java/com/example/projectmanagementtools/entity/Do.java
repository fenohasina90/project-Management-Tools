package com.example.projectmanagementtools.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Do {
    private int idDo;
    private int userId;
    private int projectId;
}
