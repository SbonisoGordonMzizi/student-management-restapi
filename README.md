# Student Management API
Student Management API is a RESTful API for managing students and their courses. It is built using Spring Boot and makes use of a MySQL database to store data.

# Prerequisites
```
Java 8 or later
Maven 3.6.3 or later
MySQL 5.7 or later
```
#Installation
```
Clone the repository
Create a MySQL database and user for the application, and configure the database connection in the application.properties file.
Run the following command to build and run the application: mvn spring-boot:run
```

# Endpoints
The API has the following endpoints:

```
GET /student/api/v1/student/{id}: retrieves a specific student by id

GET /assistant/api/v1/student/firstName/{firstName}: retrieves a specific student by firstName
GET /assistant/api/v1/student/lastName/{lastName}": retrieves a specific student by lastName
GET /assistant/api/v1/student/all: retrieves a list of all students

POST /teacher/api/v1/student/enroll : register student
POST /teacher/api/v1/student//update : update student information
DELETE /teacher/api/v1/student/deregister/{id}": deregister student by id
```
