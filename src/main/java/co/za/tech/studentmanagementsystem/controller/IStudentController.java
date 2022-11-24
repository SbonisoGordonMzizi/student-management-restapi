package co.za.tech.studentmanagementsystem.controller;

import co.za.tech.studentmanagementsystem.entity.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public interface IStudentController {
    Collection<Student> getStudentById(Long id);
}
