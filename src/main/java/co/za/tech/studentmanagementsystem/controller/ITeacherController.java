package co.za.tech.studentmanagementsystem.controller;

import co.za.tech.studentmanagementsystem.dto.StudentRequest;
import co.za.tech.studentmanagementsystem.entity.Student;



public interface ITeacherController extends IAssistantTeacherController{
    Student addStudent(StudentRequest studentRequest);
    Student updateStudent(StudentRequest studentRequest);
    Student deleteStudent(long id);
}
