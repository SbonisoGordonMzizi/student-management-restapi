package co.za.tech.studentmanagementsystem.controller;

import co.za.tech.studentmanagementsystem.entity.Student;

import java.util.Collection;

public interface IAssistantTeacherController extends IStudentController{
    Collection<Student> getStudentByFirstName(String firstName);
    Collection<Student> getStudentByLastName(String lastName);
    Collection<Student> getAllStudent();
}
