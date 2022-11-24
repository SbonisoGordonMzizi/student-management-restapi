package co.za.tech.studentmanagementsystem.repository;

import co.za.tech.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public Collection<Student> getStudentByFirstName(String firstName);
    public Collection<Student> getStudentByLastName(String lastName);
}
