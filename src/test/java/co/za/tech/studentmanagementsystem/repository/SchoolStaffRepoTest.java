package co.za.tech.studentmanagementsystem.repository;

import co.za.tech.studentmanagementsystem.entity.SchoolStaff;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ComponentScan(basePackages = {"co.za.tech.studentmanagementsystem.bootstrap"})
class SchoolStaffRepoTest {

    @Autowired
    StuffRepository staffRepository;

    @Test
    void getAllSchoolStaffDataFromDatabase(){
        assertEquals(2,staffRepository.count());
        List<SchoolStaff> schoolStaffList = staffRepository.findAll();
        assertEquals("Blony",schoolStaffList.get(0).getFirstName());
        assertEquals("Teacher",schoolStaffList.get(0).getRole());
        assertEquals("Jessica",schoolStaffList.get(1).getFirstName());
        assertEquals("Teacher",schoolStaffList.get(1).getRole());
    }

    @Test
    void getStaffById(){
        Long staffId = 1L;
        SchoolStaff schoolStaff = staffRepository.findById(staffId).get();
        assertEquals("Blony",schoolStaff.getFirstName());
        assertEquals(staffId,schoolStaff.getId());
    }

    @Test
    void getStaffByFirstName(){
        String staffFirstName = "Blony";
        Collection<SchoolStaff> schoolStaffs = staffRepository.getStaffByFirstName(staffFirstName);
        for(SchoolStaff schoolStaff : schoolStaffs) {
            assertEquals(staffFirstName, schoolStaff.getFirstName());
        }
    }


    @Test
    void getStaffByLastName(){
        String staffLastName = "Big";
        Collection<SchoolStaff> schoolStaffs = staffRepository.getStaffByLastName(staffLastName);
        for(SchoolStaff schoolStaff : schoolStaffs) {
            assertEquals(staffLastName, schoolStaff.getLastName());
        }
    }


    @Test
    void addNewStaffToDatabase(){

        SchoolStaff  teacher = new SchoolStaff("Teaching",
                "Teacher","Sindy",
                "White",'f',29);
        assertEquals(2,staffRepository.count());
        staffRepository.save(teacher);
        assertEquals(3,staffRepository.count());
    }


    @Test
    @Disabled
    void removeStaffFromDatabase(){
        SchoolStaff  teacher = new SchoolStaff("Teaching",
                "Teacher","Sindy",
                "White",'f',29);
        staffRepository.save(teacher);
        SchoolStaff  teacherR = new SchoolStaff("Teaching",
                "Teacher","Sindy",
                "White",'f',29);
        teacherR.setId(3L);

        staffRepository.delete(teacherR);
        assertEquals(2,staffRepository.count());
    }

    @Test
    void updateStaffInforFromDatabase(){
        SchoolStaff  teacher = new SchoolStaff("Teaching",
                "TeacherAssistant","Blony111",
                "Wow111",'m',26);
        teacher.setId(1L);
        Optional<SchoolStaff> optionalStaff = staffRepository.findById(teacher.getId());
        SchoolStaff toModifyStaff= optionalStaff.get();

        if(!toModifyStaff.getFirstName().equals(teacher.getFirstName())){
            toModifyStaff.setFirstName(teacher.getFirstName());
        }
        if(!toModifyStaff.getLastName().equals(teacher.getLastName())){
            toModifyStaff.setLastName(teacher.getLastName());
        }
        if(!toModifyStaff.getGender().equals(teacher.getGender())){
            toModifyStaff.setGender(teacher.getGender());
        }
        if(!toModifyStaff.getAge().equals(teacher.getAge())){
            toModifyStaff.setAge(teacher.getAge());
        }


        staffRepository.save(toModifyStaff);
        assertEquals(2,staffRepository.count());
        assertEquals("Blony111",staffRepository.findById(1L).get().getFirstName());
    }

}
