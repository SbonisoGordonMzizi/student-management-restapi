package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.Elective;
import co.za.tech.studentmanagementsystem.runtimeexception.ElectiveNotFoundException;


public interface IElectiveService {
    Elective getElectiveById(long id) throws ElectiveNotFoundException;
    Elective getElectiveByName(String electiveName) throws  ElectiveNotFoundException;
    Elective addElective(Elective elective);
    Elective updateElective(Elective elective) throws ElectiveNotFoundException;
    Elective deleteElective(Elective elective) throws ElectiveNotFoundException;
}
