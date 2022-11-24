package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.SchoolStaff;
import co.za.tech.studentmanagementsystem.runtimeexception.TeacherNotFoundException;

import java.util.Collection;

public interface IStaffService {
    SchoolStaff getSchoolStaffById(long id) throws TeacherNotFoundException;
    Collection<SchoolStaff> getSchoolStaffByFirstName(String firstName) throws TeacherNotFoundException;
    Collection<SchoolStaff> getSchoolStaffByLastName(String lastName) throws  TeacherNotFoundException;
    Collection<SchoolStaff> getAllSchoolStaff() throws  TeacherNotFoundException;
    SchoolStaff addSchoolStaff(SchoolStaff schoolStaff);
    SchoolStaff updateSchoolStaff(SchoolStaff schoolStaff) throws  TeacherNotFoundException;
    SchoolStaff deleteSchoolStaffById(Long id)throws TeacherNotFoundException;
}
