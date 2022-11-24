package co.za.tech.studentmanagementsystem.entity;


import javax.persistence.Entity;


@Entity
public class Student extends Person{

    public Student() {
    }

    public Student(String firstName,
                   String lastName,
                   Character gender,
                   Integer age) {
        super(firstName,lastName,gender,age);
    }


    @Override
    public String toString() {
        return "Person{" +
                "StudentID=" + this.getId() +'\''+
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", gender=" + this.getGender() +
                ", age=" + this.getAge() +
                '}';

    }

}
