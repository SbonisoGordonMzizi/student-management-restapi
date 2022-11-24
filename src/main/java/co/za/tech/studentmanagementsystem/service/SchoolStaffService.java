package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.SchoolStaff;
import co.za.tech.studentmanagementsystem.repository.StuffRepository;
import co.za.tech.studentmanagementsystem.runtimeexception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;


public class SchoolStaffService implements IStaffService{

    @Autowired
    private StuffRepository stuffRepository;

    public SchoolStaffService(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }

    @Override
    public SchoolStaff getSchoolStaffById(long id) {
        Optional<SchoolStaff> teacherOptional = stuffRepository.findById(id);
        if(teacherOptional.isEmpty()){
            throw new TeacherNotFoundException("Teacher Not Found");
        }
        return teacherOptional.get();
    }

    @Override
    public Collection<SchoolStaff> getSchoolStaffByFirstName(String firstName) {
        Collection<SchoolStaff> teachers = stuffRepository.getStaffByFirstName(firstName);
        if(teachers.isEmpty()){
            throw new TeacherNotFoundException("Teacher/s with "+firstName+" Name Not Found");
        }
        return teachers;
    }

    @Override
    public Collection<SchoolStaff> getSchoolStaffByLastName(String lastName) {
        Collection<SchoolStaff> teachers = stuffRepository.getStaffByLastName(lastName);
        if(teachers.isEmpty()){
            throw new TeacherNotFoundException("Teacher/s with "+lastName+" Name Not Found");
        }
        return teachers;
    }

    @Override
    public Collection<SchoolStaff> getAllSchoolStaff() {
        Collection<SchoolStaff> teacher = stuffRepository.findAll();
        if(teacher.isEmpty()){
            throw new TeacherNotFoundException("Teacher/s Not Found");
        }
        return teacher;
    }

    @Override
    public SchoolStaff addSchoolStaff(SchoolStaff schoolStaff) {
        return stuffRepository.save(schoolStaff);
    }

    @Override
    public SchoolStaff updateSchoolStaff(SchoolStaff teacher) {
        SchoolStaff teacherToBeUpdated = getSchoolStaffById(teacher.getId());

        if(!teacher.getFirstName().equals(teacherToBeUpdated.getFirstName())){
            teacherToBeUpdated.setFirstName(teacher.getFirstName());
        }
        if(!teacher.getLastName().equals(teacherToBeUpdated.getLastName())){
            teacherToBeUpdated.setLastName(teacher.getLastName());
        }
        if(!teacher.getAge().equals(teacherToBeUpdated.getAge())){
            teacherToBeUpdated.setAge(teacher.getAge());
        }
        if(!teacher.getGender().equals(teacherToBeUpdated.getGender())){
            teacherToBeUpdated.setGender(teacher.getGender());
        }
        if(!teacher.getRole().equals(teacherToBeUpdated.getRole())){
            teacherToBeUpdated.setRole(teacher.getRole());
        }
        if(!teacher.getDepartment().equals(teacherToBeUpdated.getDepartment())){
            teacherToBeUpdated.setDepartment(teacher.getDepartment());
        }
        return addSchoolStaff(teacherToBeUpdated);
    }

    @Override
    public SchoolStaff deleteSchoolStaffById(Long id) throws TeacherNotFoundException {
        SchoolStaff teacher = getSchoolStaffById(id);
        stuffRepository.deleteById(id);
        return teacher;
    }

}
