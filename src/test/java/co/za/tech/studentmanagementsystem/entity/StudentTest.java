package co.za.tech.studentmanagementsystem.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;


    @BeforeEach
    void setUp(){
        this.student = new Student();
        student.setId(1L);
        student.setFirstName("Test1");
        student.setLastName("MyTest");
        student.setAge(30);
        student.setGender('M');

    }

    @Test
    void getStudentID() {
        assertEquals(1L,student.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("Test1",student.getFirstName());
    }


    @Test
    void getLastName() {
        assertEquals("MyTest",student.getLastName());
    }


    @Test
    void getGender() {
        assertEquals('M',student.getGender());
    }


    @Test
    void getAge() {
        assertEquals(30,student.getAge());
    }

    @Test
    void equalObject(){
        Student student1 = student;
        assertEquals(student,student1);
    }

    @Test
    void studentObjectIsNotEqualToNull(){
        assertNotEquals(null,student);
    }
    @Test
    void studentObjectIsNotEqualToDifferentObjectType(){
        assertNotEquals(student,new SchoolStaff());
    }
    @Test
    void studentObjectWithSameId(){
        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Test1");
        student1.setLastName("MyTest");
        student1.setAge(30);
        student1.setGender('M');

        assertEquals(student,student1);
    }

    @Test
    void sameObjectShouldHaveSameHashCode(){
        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Test1");
        student1.setLastName("MyTest");
        student1.setAge(30);
        student1.setGender('M');

        assertEquals(student1.hashCode(),student.hashCode());
    }

    @Test
    void testingToString(){
        String expected = "Person{StudentID=1'firstName='Test1', lastName='MyTest', gender=M, age=30}";
        String actual = student.toString();
        assertEquals(actual,expected);
    }
}