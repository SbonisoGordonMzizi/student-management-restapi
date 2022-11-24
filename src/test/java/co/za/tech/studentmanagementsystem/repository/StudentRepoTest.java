package co.za.tech.studentmanagementsystem.repository;

import co.za.tech.studentmanagementsystem.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = {"co.za.tech.studentmanagementsystem.bootstrap"})
class StudentRepoTest {

    @Autowired
    StudentRepository studentRepository;


    @Test
    void getAllStudentDataFromDatabase(){
       assertEquals(2,studentRepository.count());
       List<Student> studentList = studentRepository.findAll();
       assertEquals("Vice",studentList.get(0).getFirstName());
       assertEquals("Bob",studentList.get(1).getFirstName());
    }

    @Test
    void getStudentById(){
         Long studentId = 1L;
         Student student = studentRepository.findById(studentId).get();
         assertEquals("Vice",student.getFirstName());
         assertEquals(studentId,student.getId());
    }

    @Test
    void getStudentByFirstName(){
       String studentFirstName = "Vice";
       Collection<Student> student = studentRepository.getStudentByFirstName(studentFirstName);

        for (Student value : student) {
            assertEquals(studentFirstName, value.getFirstName());
        }
    }

    @Test
    void getStudentByLastName(){
        String studentLastName = "Mzizi";
        Collection<Student> students = studentRepository.getStudentByLastName(studentLastName);

        for(Student student : students) {
            assertEquals(studentLastName, student.getLastName());
        }
    }

    @Test
    void addNewStudentToDatabase(){
        Student student  = new Student("Test1","Mytest1",'m',14);
        assertEquals(2,studentRepository.count());
        studentRepository.save(student);
        assertEquals(3,studentRepository.count());
    }

    @Test
    void removeStudentFromDatabase(){
        Student student = new Student("Vice","Mzizi",'m',20);
        student.setId(1L);
        studentRepository.delete(student);
        assertEquals(1,studentRepository.count());
    }

    @Test
    void updateStudentInforFromDatabase(){
        Student student = new Student("Vice111","Mzizi111",'m',24);
        student.setId(1L);
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        Student toModifyStudent= optionalStudent.get();
        if(!toModifyStudent.getFirstName().equals(student.getFirstName())){
            toModifyStudent.setFirstName(student.getFirstName());
        }
        if(!toModifyStudent.getLastName().equals(student.getLastName())){
            toModifyStudent.setLastName(student.getLastName());
        }
        if(!toModifyStudent.getGender().equals(student.getGender())){
            toModifyStudent.setGender(student.getGender());
        }
        if(!toModifyStudent.getAge().equals(student.getAge())){
            toModifyStudent.setAge(student.getAge());
        }

        studentRepository.save(toModifyStudent);
        assertEquals(2,studentRepository.count());
        assertEquals("Vice111",studentRepository.findById(1L).get().getFirstName());
    }

}
