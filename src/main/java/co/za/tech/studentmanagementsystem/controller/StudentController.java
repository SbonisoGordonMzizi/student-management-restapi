package co.za.tech.studentmanagementsystem.controller;

import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student/api/v1/student")
public class StudentController implements IStudentController{

    @Autowired
    private StudentService studentService;


    @GetMapping("/{id}")
    public Collection<Student> getStudentById(@PathVariable Long id){
        return List.of(studentService.getStudentById(id));
    }
}
