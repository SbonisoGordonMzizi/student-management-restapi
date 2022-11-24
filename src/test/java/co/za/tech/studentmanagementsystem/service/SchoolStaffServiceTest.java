package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.SchoolStaff;
import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.repository.StuffRepository;
import co.za.tech.studentmanagementsystem.runtimeexception.TeacherNotFoundException;
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
class SchoolStaffServiceTest {

    @Mock
    private StuffRepository stuffRepository;

    @InjectMocks
    private SchoolStaffService schoolStaffService;

    private SchoolStaff teacher;

    @BeforeEach
    void setUp(){
        teacher = new SchoolStaff("Teaching",
                "Teacher","Teacher1",
                "Brown",'m',30);
    }
    @Test
    void getSchoolStaffById() {
        when(stuffRepository.findById(1l)).thenReturn(Optional.of(teacher));
        SchoolStaff teacherReturned = schoolStaffService.getSchoolStaffById(1l);
        assertEquals("Teacher1",teacherReturned.getFirstName());
        assertEquals("Brown",teacherReturned.getLastName());
        verify(stuffRepository).findById(1l);
    }

    @Test
    void getSchoolStaffById_IfStuffNotFound_raise_exception() {
        when(stuffRepository.findById(1l)).thenReturn(Optional.empty());
        Exception exception = assertThrows(TeacherNotFoundException.class,()->{
            schoolStaffService.getSchoolStaffById(1l);
        });

        assertEquals("Teacher Not Found",exception.getMessage());

        verify(stuffRepository).findById(1l);
    }

    @Test
    void getSchoolStaffByFirstName() {
        when(stuffRepository.getStaffByFirstName("Teacher1")).thenReturn(List.of(teacher));
        Collection<SchoolStaff> teachers = schoolStaffService.getSchoolStaffByFirstName("Teacher1");
        for(SchoolStaff teacherReturned : teachers) {
            assertEquals("Teacher1", teacherReturned.getFirstName());
            assertEquals("Brown", teacherReturned.getLastName());
        }
        verify(stuffRepository).getStaffByFirstName("Teacher1");
    }

    @Test
    void getSchoolStaffByFirstName_IfStuffNotFound_raise_exception() {
        when(stuffRepository.getStaffByFirstName("Teacher1")).thenReturn(List.of());
        Exception exception = assertThrows(TeacherNotFoundException.class,()->{
            schoolStaffService.getSchoolStaffByFirstName("Teacher1");
        });

        assertEquals("Teacher/s with Teacher1 Name Not Found",exception.getMessage());

        verify(stuffRepository).getStaffByFirstName("Teacher1");
    }


    @Test
    void getSchoolStaffByLastName() {
        when(stuffRepository.getStaffByLastName("Brown")).thenReturn(List.of(teacher));
        Collection<SchoolStaff> teachers = schoolStaffService.getSchoolStaffByLastName("Brown");
        for(SchoolStaff teacherReturned : teachers) {
            assertEquals("Teacher1", teacherReturned.getFirstName());
            assertEquals("Brown", teacherReturned.getLastName());
        }
        verify(stuffRepository).getStaffByLastName("Brown");
    }

    @Test
    void getSchoolStaffByLastName_IfStuffNotFound_raise_exception() {
        when(stuffRepository.getStaffByLastName("Brown")).thenReturn(List.of());
        Exception exception = assertThrows(TeacherNotFoundException.class,()->{
            schoolStaffService.getSchoolStaffByLastName("Brown");
        });

        assertEquals("Teacher/s with Brown Name Not Found",exception.getMessage());

        verify(stuffRepository).getStaffByLastName("Brown");
    }

    @Test
    void getAllSchoolStaff() {
        when(stuffRepository.findAll()).thenReturn(List.of(teacher));
        Collection<SchoolStaff> teachers = schoolStaffService.getAllSchoolStaff();
        for(SchoolStaff teacherReturned: teachers) {
            assertEquals("Teacher1", teacherReturned.getFirstName());
            assertEquals("Brown", teacherReturned.getLastName());
        }
        verify(stuffRepository).findAll();
    }

    @Test
    void getAllSchoolStaff_IfStuffNotFound_raise_exception() {
        when(stuffRepository.findAll()).thenReturn(List.of());
        Exception exception = assertThrows(TeacherNotFoundException.class,()->{
            schoolStaffService.getAllSchoolStaff();
        });

        assertEquals("Teacher/s Not Found",exception.getMessage());

        verify(stuffRepository).findAll();
    }

    @Test
    void addSchoolStaff() {
        when(stuffRepository.save(teacher)).thenReturn(teacher);
        SchoolStaff teacherReturned = schoolStaffService.addSchoolStaff(teacher);
        assertEquals("Teacher1",teacherReturned.getFirstName());
        assertEquals("Brown",teacherReturned.getLastName());
        verify(stuffRepository).save(teacher);
    }

    @Test
    @Disabled
    void updateSchoolStaff() {
    }

    @Test
    void deleteSchoolStaff() {
        when(stuffRepository.findById(1l)).thenReturn(Optional.of(teacher));
        doNothing().when(stuffRepository).deleteById(1l);
        SchoolStaff deletedTeacher = schoolStaffService.deleteSchoolStaffById(1l);

        assertEquals("Teacher1",deletedTeacher.getFirstName());
        assertEquals("Brown",deletedTeacher.getLastName());

        verify(stuffRepository).deleteById(1l);
        verify(stuffRepository).findById(1l);
    }
}