package co.za.tech.studentmanagementsystem.repository;

import co.za.tech.studentmanagementsystem.entity.Elective;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectiveRepository extends JpaRepository<Elective,Long> {
  public Optional<Elective> getElectiveByElective(String electiveName);
}
