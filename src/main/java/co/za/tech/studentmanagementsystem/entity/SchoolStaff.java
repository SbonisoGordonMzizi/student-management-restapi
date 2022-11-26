package co.za.tech.studentmanagementsystem.entity;

import javax.persistence.*;


@Entity
public class SchoolStaff extends Person{
    private String department;
    private String role;
    @OneToOne(mappedBy = "schoolStaff")
    private ElectiveEntity elective;
    public SchoolStaff(){}

    public SchoolStaff( String department,
                       String role, String firstName,
                       String lastName, Character gender,
                       Integer age) {

        super(firstName,lastName,gender,age);
        this.department = department;
        this.role = role;

    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Person{" +
                ",StuffId=" + this.getId()+'\''+
                ",department=" + this.getDepartment()+
                ",firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", gender=" + this.getGender() +
                ", age=" + this.getAge() +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SchoolStaff that = (SchoolStaff) o;

        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
