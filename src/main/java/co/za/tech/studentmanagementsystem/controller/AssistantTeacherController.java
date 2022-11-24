package co.za.tech.studentmanagementsystem.controller;

import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;



@RestController
@RequestMapping("/assistant/api/v1/student")
public class AssistantTeacherController  extends StudentController implements IAssistantTeacherController{

    @Autowired
    private StudentService studentService;


    @Override
    @GetMapping("/firstName/{firstName}")
    public Collection<Student> getStudentByFirstName(@PathVariable String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }

    @Override
    @GetMapping("/lastName/{lastName}")
    public Collection<Student> getStudentByLastName(@PathVariable String lastName) {
        return studentService.getStudentByLastName(lastName);
    }

    @Override
    @GetMapping("/all")
    public Collection<Student> getAllStudent() {
        return studentService.getAllStudent();
    }
}