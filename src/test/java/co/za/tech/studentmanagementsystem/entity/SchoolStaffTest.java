package co.za.tech.studentmanagementsystem.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolStaffTest {

    private SchoolStaff staff1;

    @BeforeEach
    void setUp(){
        staff1 = new SchoolStaff();
        staff1.setId(1L);
        staff1.setRole("Teacher");
        staff1.setDepartment("Teaching");
        staff1.setFirstName("Test1");
        staff1.setLastName("MyTest");
        staff1.setAge(30);
        staff1.setGender('M');

    }
    @Test
    void getStuffId() {
        assertEquals(1L,staff1.getId());
    }


    @Test
    void getDepartment() {
        assertEquals("Teaching",staff1.getDepartment());
    }


    @Test
    void getRole() {
        assertEquals("Teacher",staff1.getRole());
    }


    @Test
    void getFirstName() {
        assertEquals("Test1",staff1.getFirstName());
    }



    @Test
    void getLastName() {
        assertEquals("MyTest",staff1.getLastName());
    }



    @Test
    void getGender() {
        assertEquals('M',staff1.getGender());
    }



    @Test
    void getAge() {
        assertEquals(30,staff1.getAge());
    }



    @Test
    void equalObject(){
        SchoolStaff staff = staff1;
        assertEquals(staff,staff1);
    }

    @Test
    void studentObjectIsNotEqualToNull(){
        assertNotEquals(null,staff1);
    }
    @Test
    void studentObjectIsNotEqualToDifferentObjectType(){
        assertNotEquals(staff1,new SchoolStaff());
    }

    @Test
    void studentObjectWithSameId(){
        SchoolStaff staff = new SchoolStaff();
        staff.setId(1L);
        staff.setRole("Teacher");
        staff.setDepartment("Teaching");
        staff.setFirstName("Test1");
        staff.setLastName("MyTest");
        staff.setAge(30);
        staff.setGender('M');

        assertEquals(staff,staff1);
    }

    @Test
    void sameStudentShouldHaveSameHashCode(){
        SchoolStaff staff = new SchoolStaff();
        staff.setId(1L);
        staff.setRole("Teacher");
        staff.setDepartment("Teaching");
        staff.setFirstName("Test1");
        staff.setLastName("MyTest");
        staff.setAge(30);
        staff.setGender('M');
        assertEquals(staff1.hashCode(),staff.hashCode());

    }

    @Test
    void testingToString(){
        String expected = "Person{,StuffId=1',department=Teaching,firstName='Test1', lastName='MyTest', gender=M, age=30}";
        String actual = staff1.toString();
        assertEquals(expected,actual);
    }



}