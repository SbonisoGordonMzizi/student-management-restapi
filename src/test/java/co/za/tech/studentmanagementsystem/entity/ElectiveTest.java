package co.za.tech.studentmanagementsystem.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ElectiveTest {

    private ElectiveEntity elective;
    private ElectiveEntity elective2;
    private ElectiveEntity elective3;

    @BeforeEach
    void setUp() {
        //Student Object
        Student student2 = new Student ("Bob","Team",'f',18);

        //Teacher Objects
        SchoolStaff  teacherDevOps = new SchoolStaff("Teaching",
                "Teacher","Blony",
                "Wow",'m',26);

        //Elective Object
        elective = new ElectiveEntity("DevOps", Set.of(student2),teacherDevOps);
        elective.setId(100L);
        elective3 = new ElectiveEntity("DevOps", Set.of(student2),teacherDevOps);
        elective3.setId(100L);
        elective2 = new ElectiveEntity("DevOps", Set.of(student2),teacherDevOps);
        elective2.setId(10L);
    }

    @Test
    void getStudent() {
        Set<Student> students = elective.getStudent();
        assertNotNull(students);
        assertEquals(1,students.size());
    }

    @Test
    void setStudent() {
        Student student1 = new Student ("Bob","Team",'f',18);
        Student student2 = new Student ("Bob","Team",'f',18);
        student1.setId(10L);
        student2.setId(5L);
        elective.setStudent(Set.of(student1,student2));
        assertEquals(2,elective.getStudent().size());
    }

    @Test
    void setId() {
        elective.setId(3L);
        assertEquals(3,elective.getId());
    }

    @Test
    void getElective() {
        assertEquals("DevOps",elective.getElective());
    }

    @Test
    void setElective() {
        elective.setElective("Java 8");
        assertEquals("Java 8",elective.getElective());
    }

    @Test
    void getTeacher() {
        SchoolStaff teacher = elective.getSchoolStaff();
        assertEquals("Teaching",teacher.getDepartment());
    }

    @Test
    void setTeacher() {
        SchoolStaff  teacherDevOps = new SchoolStaff("Teaching",
                "Teacher","Test1",
                "Wow",'m',26);
        teacherDevOps.setId(100L);
        elective.setSchoolStaff(teacherDevOps);
        assertEquals("Test1",teacherDevOps.getFirstName());
    }

    @Test
    void testToString() {
        String expected = "Elective{id=100, elective='DevOps'}";
        String actual = elective.toString();
        assertEquals(expected,actual);
    }

    @Test
    void sameInstanceShouldBeEqual() {
        assertEquals(elective,elective);
    }

    @Test
    void sameInstanceDifferentIdShouldNotBeEqual() {
        assertNotEquals(elective,elective2);
    }

    @Test
    void samePropertiesShouldBeEqual() {
        assertEquals(elective,elective3);
    }

    @Test
    void testHashCode() {
        Integer expected = 2043655833;
        Integer actual = elective.hashCode();
        assertEquals(expected,actual);
    }
}