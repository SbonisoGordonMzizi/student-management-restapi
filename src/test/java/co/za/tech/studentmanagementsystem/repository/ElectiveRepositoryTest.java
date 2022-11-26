package co.za.tech.studentmanagementsystem.repository;

import co.za.tech.studentmanagementsystem.entity.ElectiveEntity;
import co.za.tech.studentmanagementsystem.entity.SchoolStaff;
import co.za.tech.studentmanagementsystem.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = {"co.za.tech.studentmanagementsystem.bootstrap"})
class ElectiveRepositoryTest {

    @Autowired
    private ElectiveRepository electiveRepository;
    private ElectiveEntity qa;
    private ElectiveEntity cloud;
    private ElectiveEntity networking;

    @BeforeEach
    void setUp(){
        //Student Object
        Student student1 = new Student("Test1","smith",'m',27);
        Student student2 = new Student ("Test2","white",'f',17);


        //Teacher Objects
        SchoolStaff teacherDevOps = new SchoolStaff("Teaching",
                "Teacher","Tom",
                "Brown",'m',33);


        //Teacher assistant
        SchoolStaff teacherMobileDev = new SchoolStaff("Teaching",
                "Teacher","Black",
                "Mouth",'f',23);


        //ELECTIVE Objects
        qa = new ElectiveEntity("QA", Set.of(student1),teacherDevOps);
        cloud = new ElectiveEntity("Cloud", Set.of(student2),teacherMobileDev);
        networking = new ElectiveEntity("Networking", Set.of(student2));

    }

    @Test
    void addElectiveWithStudentAndTeacher(){
        assertEquals(2,electiveRepository.count());
        electiveRepository.save(qa);
        assertEquals(3,electiveRepository.count());
        electiveRepository.save(cloud);
        assertEquals(4,electiveRepository.count());
    }

    @Test
    void addElectiveWithStudent(){
        assertEquals(2,electiveRepository.count());
        electiveRepository.save(networking);
        assertEquals(3,electiveRepository.count());
    }

    @Test
    void addElective(){
        ElectiveEntity web = new ElectiveEntity("Web Dev");
        assertEquals(2,electiveRepository.count());
        electiveRepository.save(web);
        assertEquals(3,electiveRepository.count());
    }

    @Test
    void getAllElective(){
        electiveRepository.save(qa);
        electiveRepository.save(cloud);
        electiveRepository.save(networking);
        assertEquals(5,electiveRepository.count());
        Collection<ElectiveEntity> electives = electiveRepository.findAll();
        assertEquals(5,electives.size());
    }

    @Test
    void findElectiveByName(){
        electiveRepository.save(qa);
        electiveRepository.save(cloud);
        electiveRepository.save(networking);
        assertEquals(5,electiveRepository.count());
        Optional<ElectiveEntity> cloudElective = electiveRepository.getElectiveByElective("Cloud");
        assertFalse(cloudElective.isEmpty());
        assertEquals("Cloud",cloudElective.get().getElective());
    }

    @Test
    void findElectiveById(){
        electiveRepository.save(qa);
        Long id = qa.getId();
        electiveRepository.save(cloud);
        electiveRepository.save(networking);
        assertEquals(5,electiveRepository.count());
        Optional<ElectiveEntity> qaElective = electiveRepository.findById(id);
        assertFalse(qaElective.isEmpty());
        assertEquals("QA",qaElective.get().getElective());
    }

    @Test
    void deleteElective(){
        electiveRepository.save(qa);
        electiveRepository.save(cloud);
        electiveRepository.save(networking);
        assertEquals(5,electiveRepository.count());
        electiveRepository.delete(cloud);
        assertEquals(4,electiveRepository.count());
        electiveRepository.delete(networking);
        assertEquals(3,electiveRepository.count());
    }


}