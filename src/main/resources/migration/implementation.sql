DROP DATABASE IF EXISTS spring_project;
CREATE DATABASE spring_project;

\c spring_project


CREATE TABLE "user"(
    id_user SERIAL PRIMARY KEY,
    user_name VARCHAR(200),
    email VARCHAR(200),
    password VARCHAR(200),
    created_at TIMESTAMP
);

CREATE TABLE project(
    id_project SERIAL PRIMARY KEY,
    project_name VARCHAR(200),
    description TEXT,
    start_date DATE,
    end_date DATE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE "do"(
    id_user INT REFERENCES "user"(id_user),
    id_project INT REFERENCES project(id_project)
);

CREATE TABLE task(
    id_task SERIAL PRIMARY KEY,
    task_name VARCHAR(200),
    description TEXT,
    deadline DATE,
    task_status VARCHAR(200),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    created_by INT REFERENCES "user"(id_user),
    for_project INT REFERENCES project(id_project)
);

