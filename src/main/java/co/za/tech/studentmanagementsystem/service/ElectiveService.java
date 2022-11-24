package co.za.tech.studentmanagementsystem.service;

import co.za.tech.studentmanagementsystem.entity.Elective;
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
    public Elective getElectiveById(long id) {
        Optional<Elective> electiveOptional = electiveRepository.findById(id);
        if(electiveOptional.isEmpty()){
            throw new ElectiveNotFoundException("Elective with "+id+" Id Not Found");
        }
        return electiveOptional.get();
    }

    @Override
    public Elective getElectiveByName(String electiveName) {
        Optional<Elective> electiveOptional = electiveRepository.getElectiveByElective(electiveName);
        if(electiveOptional.isEmpty()){
            throw new ElectiveNotFoundException("Elective with "+electiveName+" Name Not Found");
        }
        return electiveOptional.get();
    }

    @Override
    public Elective addElective(Elective elective) {
        return electiveRepository.save(elective);
    }

    @Override
    public Elective updateElective(Elective elective) {
        Elective electiveToUpdate = electiveRepository.getReferenceById(elective.getId());
        if(!elective.getElective().equals(electiveToUpdate.getElective())){
            electiveToUpdate.setElective(elective.getElective());
        }
        return electiveRepository.save(electiveToUpdate);
    }

    @Override
    public Elective deleteElective(Elective elective) {
        Elective electiveToDelete = getElectiveById(elective.getId());
        electiveRepository.delete(elective);
        return electiveToDelete;
    }
}
