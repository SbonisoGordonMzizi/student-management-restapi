package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.runtimeexception.StudentNotFoundException;

import java.util.Collection;

public interface IStudentService {
    Student getStudentById(long id) throws StudentNotFoundException;
    Collection<Student> getStudentByFirstName(String firstName) throws StudentNotFoundException;
    Collection<Student> getStudentByLastName(String lastName) throws StudentNotFoundException;
    Collection<Student> getAllStudent() throws StudentNotFoundException;
    Student addStudent(Student student);
    Student updateStudent(Student student) throws StudentNotFoundException;
    Student deleteStudentById(Long id) throws StudentNotFoundException;
}
