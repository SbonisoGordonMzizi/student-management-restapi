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
GET /students: retrieves a list of all students
GET /students/{id}: retrieves a specific student by id
POST /students: creates a new student
PUT /students/{id}: updates a specific student by id
DELETE /students/{id}: deletes a specific student by id
GET /students/{id}/courses: retrieves a list of courses for a specific student
POST /students/{id}/courses: adds a course to a specific student
DELETE /students/{id}/courses/{courseId}: removes a course from a specific student
```
