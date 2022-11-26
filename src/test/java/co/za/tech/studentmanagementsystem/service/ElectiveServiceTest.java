package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.ElectiveEntity;
import co.za.tech.studentmanagementsystem.entity.SchoolStaff;
import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.repository.ElectiveRepository;
import co.za.tech.studentmanagementsystem.runtimeexception.ElectiveNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ElectiveServiceTest {

    @Mock
    private ElectiveRepository electiveRepository;

    @InjectMocks
    private ElectiveService electiveService;

    private ElectiveEntity elective;

    @BeforeEach
    void setUp(){
        Student student2 = new Student ("Bob","Team",'f',18);
        SchoolStaff teacherDevOps = new SchoolStaff("Teaching",
                "Teacher","Blony",
                "Wow",'m',26);

       elective = new ElectiveEntity("DevOps", Set.of(student2),teacherDevOps);
       elective.setId(1l);
    }

    @Test
    void getElectiveById() {
        when(electiveRepository.findById(1l)).thenReturn(Optional.of(elective));
        ElectiveEntity electiveRetured = electiveService.getElectiveById(1l);
        assertEquals("DevOps",electiveRetured.getElective());
        verify(electiveRepository).findById(1l);
    }

    @Test
    void getElectiveById_ifNotFound_raiseException() {
        when(electiveRepository.findById(1l)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ElectiveNotFoundException.class,() -> {
                    electiveService.getElectiveById(1l);
                });
        assertEquals("Elective with 1 Id Not Found",exception.getMessage());
        verify(electiveRepository).findById(1l);
    }

    @Test
    void getElectiveByName() {
        when(electiveRepository.getElectiveByElective("DevOps")).thenReturn(Optional.of(elective));
        ElectiveEntity electiveRetured = electiveService.getElectiveByName("DevOps");
        assertEquals("DevOps",electiveRetured.getElective());
        verify(electiveRepository).getElectiveByElective("DevOps");
    }

    @Test
    void getElectiveByName_ifNotFound_raiseException() {
        when(electiveRepository.getElectiveByElective("DevOps")).thenReturn(Optional.empty());

        Exception exception = assertThrows(ElectiveNotFoundException.class,() -> {
            electiveService.getElectiveByName("DevOps");
        });
        assertEquals("Elective with DevOps Name Not Found",exception.getMessage());
        verify(electiveRepository).getElectiveByElective("DevOps");
    }

    @Test
    void addElective() {
        when(electiveRepository.save(elective)).thenReturn(elective);
       ElectiveEntity electiveR = electiveService.addElective(elective);
       assertEquals(1,electiveR.getId());
       assertEquals("DevOps", electiveR.getElective());
    }

    @Test
    @Disabled
    void updateElective() {
    }

    @Test
    void deleteElective() {
        when(electiveRepository.findById(1l)).thenReturn(Optional.of(elective));
        doNothing().when(electiveRepository).delete(elective);
        ElectiveEntity deletedElective  = electiveService.deleteElective(elective);

        assertEquals("DevOps",deletedElective.getElective());

        verify(electiveRepository).delete(elective);
        verify(electiveRepository).findById(1l);
    }
}