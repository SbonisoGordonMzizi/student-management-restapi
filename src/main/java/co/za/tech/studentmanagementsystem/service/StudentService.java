package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.repository.StudentRepository;
import co.za.tech.studentmanagementsystem.runtimeexception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class StudentService  implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(long id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("Student with Id "+id+", Not Found");
        }
        return studentOptional.get();
    }

    @Override
    public Collection<Student> getStudentByFirstName(String firstName) {
        Collection<Student> students = studentRepository.getStudentByFirstName(firstName);
        if(students.isEmpty()){
            throw new StudentNotFoundException("Student/s with "+firstName+" as FirstName, Not Found");
        }
        return students;
    }

    @Override
    public Collection<Student> getStudentByLastName(String lastName) {
        Collection<Student> students = studentRepository.getStudentByLastName(lastName);
        if(students.isEmpty()){
            throw new StudentNotFoundException("Student/s with "+lastName+" as LastName, Not Found");
        }
        return students;
    }

    @Override
    public Collection<Student> getAllStudent() {
        Collection<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            throw new StudentNotFoundException("Student/s Not Found");
        }
        return students;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student studentToBeUpdated = getStudentById(student.getId());

        if(!student.getFirstName().equals(studentToBeUpdated.getFirstName())){
            studentToBeUpdated.setFirstName(student.getFirstName());
        }
        if(!student.getLastName().equals(studentToBeUpdated.getLastName())){
            studentToBeUpdated.setLastName(student.getLastName());
        }
        if(!student.getAge().equals(studentToBeUpdated.getAge())){
            studentToBeUpdated.setAge(student.getAge());
        }
        if(!student.getGender().equals(studentToBeUpdated.getGender())){
            studentToBeUpdated.setGender(student.getGender());
        }
        return addStudent(studentToBeUpdated);
    }

    @Override
    public Student deleteStudentById(Long id) {
        Student student = getStudentById(id);
        studentRepository.deleteById(id);
        return student;
    }
}
