package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.repository.StudentRepository;
import co.za.tech.studentmanagementsystem.runtimeexception.StudentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private  StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp(){
        student = new Student (
                "Bob",
                "White",
                'f',
                18);
    }

    @Test
    void getStudentById() {
         when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
         Student studentOptional = studentService.getStudentById(1L);
         assertEquals("Bob",studentOptional.getFirstName());
         assertEquals("White",studentOptional.getLastName());
         assertEquals('f',studentOptional.getGender());
         assertEquals(18,studentOptional.getAge());
         verify(studentRepository).findById(1l);
    }

    @Test
    void getStudentByIdNotFound() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(StudentNotFoundException.class,() ->{
            studentService.getStudentById(1l);
        });
        assertEquals("Student with Id 1, Not Found",exception.getMessage());
        verify(studentRepository).findById(1l);
    }

    @Test
    void getStudentByFirstName() {
        when(studentRepository.getStudentByFirstName("Bob")).thenReturn(List.of(student));
        Collection<Student> students = studentService.getStudentByFirstName("Bob");
        for(Student student : students){
            assertEquals("Bob",student.getFirstName());
            assertEquals("White",student.getLastName());
            assertEquals('f',student.getGender());
            assertEquals(18,student.getAge());
        }
        verify(studentRepository).getStudentByFirstName("Bob");
    }

    @Test
    void getStudentByIdNotFound1() {
        when(studentRepository.getStudentByFirstName("Bob")).thenReturn(List.of());
        Exception exception = assertThrows(StudentNotFoundException.class,() ->{
            studentService.getStudentByFirstName("Bob");
        });
        assertEquals("Student/s with Bob as FirstName, Not Found",exception.getMessage());
        verify(studentRepository).getStudentByFirstName("Bob");
    }


    @Test
    void getStudentByLastName() {
        when(studentRepository.getStudentByLastName("White")).thenReturn(List.of(student));
        Collection<Student> students = studentService.getStudentByLastName("White");
        for(Student student : students){
            assertEquals("Bob",student.getFirstName());
            assertEquals("White",student.getLastName());
            assertEquals('f',student.getGender());
            assertEquals(18,student.getAge());
        }
        verify(studentRepository).getStudentByLastName("White");
    }

    @Test
    void getStudentByIdNotFound3() {
        when(studentRepository.getStudentByLastName("White")).thenReturn(List.of());
        Exception exception = assertThrows(StudentNotFoundException.class,() ->{
            studentService.getStudentByLastName("White");
        });
        assertEquals("Student/s with White as LastName, Not Found",exception.getMessage());
        verify(studentRepository).getStudentByLastName("White");
    }

    @Test
    void getAllStudent() {
        when(studentRepository.findAll()).thenReturn(List.of(student));
        Collection<Student> students = studentService.getAllStudent();
        for(Student student : students){
            assertEquals("Bob",student.getFirstName());
            assertEquals("White",student.getLastName());
            assertEquals('f',student.getGender());
            assertEquals(18,student.getAge());
        }
        verify(studentRepository).findAll();
    }

    @Test
    void getStudentByIdNotFound2() {
        when(studentRepository.findAll()).thenReturn(List.of());
        Exception exception = assertThrows(StudentNotFoundException.class,() ->{
            studentService.getAllStudent();
        });
        assertEquals("Student/s Not Found",exception.getMessage());
        verify(studentRepository).findAll();
    }

    @Test
    void addStudent() {
        when(studentRepository.save(student)).thenReturn(student);
        Student student_ = studentService.addStudent(student);

        assertEquals("Bob",student_.getFirstName());
        assertEquals("White",student_.getLastName());
        assertEquals('f',student_.getGender());
        assertEquals(18,student_.getAge());

        verify(studentRepository).save(student);
    }

    @Test
    @Disabled
    void updateStudent() {
        Student expected = new Student (
                "Vice",
                "Black",
                'M',
                19);
    }

    @Test
    void deleteStudent(){
       when(studentRepository.findById(1l)).thenReturn(Optional.of(student));
       doNothing().when(studentRepository).deleteById(1l);
       Student deletedStudent = studentService.deleteStudentById(1l);

        assertEquals("Bob",deletedStudent.getFirstName());
        assertEquals("White",deletedStudent.getLastName());
        assertEquals('f',deletedStudent.getGender());
        assertEquals(18,deletedStudent.getAge());

        verify(studentRepository).deleteById(1l);
        verify(studentRepository).findById(1l);
    }

}