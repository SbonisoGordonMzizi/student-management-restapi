package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.ElectiveEntity;
import co.za.tech.studentmanagementsystem.repository.ElectiveRepository;
import co.za.tech.studentmanagementsystem.runtimeexception.ElectiveNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

public class ElectiveService  implements IElectiveService{

    @Autowired
    private ElectiveRepository electiveRepository;

    public ElectiveService(ElectiveRepository electiveRepository) {
        this.electiveRepository = electiveRepository;
    }

    @Override
    public ElectiveEntity getElectiveById(long id) {
        Optional<ElectiveEntity> electiveOptional = electiveRepository.findById(id);
        if(electiveOptional.isEmpty()){
            throw new ElectiveNotFoundException("Elective with "+id+" Id Not Found");
        }
        return electiveOptional.get();
    }

    @Override
    public ElectiveEntity getElectiveByName(String electiveName) {
        Optional<ElectiveEntity> electiveOptional = electiveRepository.getElectiveByElective(electiveName);
        if(electiveOptional.isEmpty()){
            throw new ElectiveNotFoundException("Elective with "+electiveName+" Name Not Found");
        }
        return electiveOptional.get();
    }

    @Override
    public ElectiveEntity addElective(ElectiveEntity elective) {
        return electiveRepository.save(elective);
    }

    @Override
    public ElectiveEntity updateElective(ElectiveEntity elective) {
        ElectiveEntity electiveToUpdate = electiveRepository.getReferenceById(elective.getId());
        if(!elective.getElective().equals(electiveToUpdate.getElective())){
            electiveToUpdate.setElective(elective.getElective());
        }
        return electiveRepository.save(electiveToUpdate);
    }

    @Override
    public ElectiveEntity deleteElective(ElectiveEntity elective) {
        ElectiveEntity electiveToDelete = getElectiveById(elective.getId());
        electiveRepository.delete(elective);
        return electiveToDelete;
    }
}
