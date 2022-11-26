package co.za.tech.studentmanagementsystem.controller;

import co.za.tech.studentmanagementsystem.dto.StudentRequest;
import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/teacher/api/v1/student")
public class TeacherController extends  AssistantTeacherController implements ITeacherController{

    @Autowired
    private StudentService studentService;

    public TeacherController(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    @PostMapping("/enroll")
    public Student addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        Student student = new Student(
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                studentRequest.getGender().charAt(0),
                studentRequest.getAge());
        return studentService.addStudent(student);
    }

    @Override
    @PostMapping("/update")
    public Student updateStudent(@RequestBody @Valid StudentRequest studentRequest) {
        Student student = new Student(
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                studentRequest.getGender().charAt(0),
                studentRequest.getAge());
        return studentService.updateStudent(student);
    }

    @Override
    @DeleteMapping("/deregister/{id}")
    public Student deleteStudent(@PathVariable long id) {
        return studentService.deleteStudentById(id);
    }
}
