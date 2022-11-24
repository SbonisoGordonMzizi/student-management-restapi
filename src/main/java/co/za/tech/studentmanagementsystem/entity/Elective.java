package co.za.tech.studentmanagementsystem.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="electives")
public class Elective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String elective;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "elective_id",
            referencedColumnName = "id"
    )
    private Set<Student> student;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private SchoolStaff schoolStaff;
    public Elective() {
    }

    public Elective(String elective){
        this.elective = elective;
    }

    public Elective(String elective,Set<Student> person) {
        this(elective);
        this.student = person;
    }
    public Elective(String elective,Set<Student> person,SchoolStaff schoolStaff) {
        this(elective,person);
        this.schoolStaff = schoolStaff;
    }

    public SchoolStaff getSchoolStaff() {
        return schoolStaff;
    }

    public void setSchoolStaff(SchoolStaff schoolStaff) {
        this.schoolStaff = schoolStaff;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getElective() {
        return elective;
    }

    public void setElective(String elective) {
        this.elective = elective;
    }

    @Override
    public String toString() {
        return "Elective{" +
                "id=" + id +
                ", elective='" + elective + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elective elective1 = (Elective) o;

        if (id != null ? !id.equals(elective1.id) : elective1.id != null) return false;
        return elective != null ? elective.equals(elective1.elective) : elective1.elective == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (elective != null ? elective.hashCode() : 0);
        return result;
    }
}
