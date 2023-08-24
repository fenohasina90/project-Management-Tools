DROP DATABASE IF EXISTS spring_project;
CREATE DATABASE spring_project;

\c spring_project


CREATE TABLE "user"(
    id_user SERIAL PRIMARY KEY,
    user_name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE project(
    id_project SERIAL PRIMARY KEY,
    project_name VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE "do"(
    id_user INT REFERENCES "user"(id_user),
    id_project INT REFERENCES project(id_project)
);

CREATE TABLE task(
    id_task SERIAL PRIMARY KEY NOT NULL,
    task_name VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    deadline DATE NOT NULL,
    task_status VARCHAR(200) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by INT REFERENCES "user"(id_user),
    for_project INT REFERENCES project(id_project)
);


INSERT INTO "user" (user_name, email, password, created_at) VALUES
    ('John Doe', 'john.doe@example.com', 'securepassword1', NOW()),
    ('Jane Smith', 'jane.smith@example.com', 'secretpass123', NOW()),
    ('Michael Johnson', 'michael.johnson@example.com', 'mypassword456', NOW()),
    ('Emily Brown', 'emily.brown@example.com', 'safeandsecure', NOW()),
    ('Ava Robinson', 'ava.robinson@example.com', 'letmein567', NOW());

INSERT INTO project (project_name, description, start_date, end_date, created_at, updated_at) VALUES
    ('Projet A', 'Description du projet A', '2023-09-01', '2023-12-15', NOW(), NOW()),
    ('Projet B', 'Description du projet B', '2023-08-15', '2023-11-30', NOW(), NOW()),
    ('Projet C', 'Description du projet C', '2023-10-01', '2024-01-31', NOW(), NOW()),
    ('Projet D', 'Description du projet D', '2023-09-20', '2024-02-28', NOW(), NOW()),
    ('Projet E', 'Description du projet E', '2023-09-05', '2023-12-05', NOW(), NOW());


INSERT INTO "do" (id_user, id_project) VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (1, 3),
    (4, 3);

INSERT INTO task (task_name, description, deadline, task_status, created_at, updated_at, created_by, for_project) VALUES
    ('Développement Front-End', 'Concevoir et développer l interface utilisateur du projet A', '2023-10-15', 'En cours', NOW(), NOW(), 1, 1),
    ('Analyse de Marché', 'Effectuer une analyse approfondie des tendances du marché pour le projet B', '2023-09-30', 'À faire', NOW(), NOW(), 2, 2),
    ('Tests de Performance', 'Exécuter des tests de performance sur le système pour le projet C', '2023-11-05', 'Planifié', NOW(), NOW(), 3, 3),
    ('Rédaction du Rapport', 'Rédiger le rapport final sur les résultats du projet D', '2023-12-10', 'En attente', NOW(), NOW(), 1, 4),
    ('Intégration API', 'Intégrer les API externes dans le projet E', '2023-09-25', 'En cours', NOW(), NOW(), 4, 5);

