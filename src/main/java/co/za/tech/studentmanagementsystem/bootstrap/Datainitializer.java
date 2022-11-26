package co.za.tech.studentmanagementsystem.bootstrap;

import co.za.tech.studentmanagementsystem.entity.ElectiveEntity;
import co.za.tech.studentmanagementsystem.entity.SchoolStaff;
import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.repository.ElectiveRepository;
import co.za.tech.studentmanagementsystem.repository.StudentRepository;
import co.za.tech.studentmanagementsystem.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class Datainitializer implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StuffRepository stuffRepository;
    @Autowired
    private ElectiveRepository electiveRepository;

    public Datainitializer(StudentRepository repository,StuffRepository stuffRepository) {
        this.studentRepository = repository;
        this.stuffRepository = stuffRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        //Student Object
        Student student1 = new Student("Vice","Mzizi",'m',20);
        Student student2 = new Student ("Bob","Team",'f',18);


        //Teacher Objects
        SchoolStaff  teacherDevOps = new SchoolStaff("Teaching",
                "Teacher","Blony",
                "Wow",'m',26);


        //Teacher assistant
        SchoolStaff teacherMobileDev = new SchoolStaff("Teaching",
                "Teacher","Jessica",
                "Big",'f',21);


        //ELECTIVE Objects
        ElectiveEntity devOps = new ElectiveEntity("DevOps",Set.of(student1),teacherDevOps);
        electiveRepository.save(devOps);
        ElectiveEntity mobileDev = new ElectiveEntity("MobileDev", Set.of(student2),teacherMobileDev);
        electiveRepository.save(mobileDev);


    }
}
