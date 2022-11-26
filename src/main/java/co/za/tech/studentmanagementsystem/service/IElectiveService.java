package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.ElectiveEntity;
import co.za.tech.studentmanagementsystem.runtimeexception.ElectiveNotFoundException;


public interface IElectiveService {
    ElectiveEntity getElectiveById(long id) throws ElectiveNotFoundException;
    ElectiveEntity getElectiveByName(String electiveName) throws  ElectiveNotFoundException;
    ElectiveEntity addElective(ElectiveEntity elective);
    ElectiveEntity updateElective(ElectiveEntity elective) throws ElectiveNotFoundException;
    ElectiveEntity deleteElective(ElectiveEntity elective) throws ElectiveNotFoundException;
}
