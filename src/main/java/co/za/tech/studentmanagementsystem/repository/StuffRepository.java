package co.za.tech.studentmanagementsystem.repository;

import co.za.tech.studentmanagementsystem.entity.SchoolStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface StuffRepository extends JpaRepository<SchoolStaff,Long> {
    public Collection<SchoolStaff> getStaffByFirstName(String firstName);
    public Collection<SchoolStaff> getStaffByLastName(String lastName);
}
