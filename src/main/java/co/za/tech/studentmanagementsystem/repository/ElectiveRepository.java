package co.za.tech.studentmanagementsystem.repository;

import co.za.tech.studentmanagementsystem.entity.ElectiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectiveRepository extends JpaRepository<ElectiveEntity,Long> {
  public Optional<ElectiveEntity> getElectiveByElective(String electiveName);
}
