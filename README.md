# Projet de Gestion d'Outils de Projet

This project is a project tool management application similar to Jira or Trello. It lets you manage projects, tasks and users using REST APIs. The application is built using Spring Framework, JDBC and PostgreSQL.

## Requirements

- Java 8 or higher
- Maven
- PostgreSQL

## Installation

### 1. Clone this repository on your local machine:

- `git clone https://github.com/fenohasina90/project-Management-Tools.git`
- `cd project-Management-Tools`

### 2. Configure the PostgreSQL database 

To configure the database and create the necessary tables, follow these steps :

1. Make sure you have PostgreSQL installed on your machine and that it's running.

2. Open your terminal and access the project directory.

3. In the directory `src/main/resources/migration/`, you will find the file `implementation.sql`. This file contains all the SQL queries to create the database and tables, as well as insertion examples for this application.

4. Modify the `src/main/resources/application.properties` file to configure database connection information:  


             DB_URL=jdbc:postgresql://localhost/spring_project
             DB_USERNAME=votre_utilisateur
             DB_PASSWORD=votre_mot_de_passe

## How to use the API
The Project Tools API can be accessed at `http://localhost:8080`.


### Users

- `GET /users`: Recover the list of all users.
- `GET /users/{id}`: Recover user details by ID.
- `POST /users`: Create a new user.
- `PUT /users/{id}`: Update user details by ID.
- `DELETE /users/{id}`: Delete a user by ID.

### Projects

- `GET /projects`: Recover the list of all project.
- `GET /projects/{id}`: Recover project details by ID.
- `POST /projects`: Create a new project.
- `PUT /projects/{id}`: Update project details by ID.
- `DELETE /projects/{id}`: Delete a project by ID.

### Tasks
- `GET /tasks`: Recover the list of all task.
- `GET /tasks/{id}`: Recover task details by ID.
- `POST /tasks`: Create a new task.
- `PUT /tasks/{taskId}`: Update task details by ID.
- `DELETE /tasks/{taskId}`: Delete a task by ID.

### Do
-  `GET /do`:  Fetches a list of all user-project relationships.
-  `GET /do/{id}`: Fetches the user-project relationship corresponding to the specified ID.
-  `POST /do`: Inserts a new user-project relationship using the provided data.
-  `PUT /do/{id}`: Updates the user-project relationship corresponding to the specified ID using the provided data.
-  `DELETE /do/{id}`: Deletes the user-project relationship corresponding to the specified ID.
