package com.luv2code.cruddemo.entity;

// we should follow the best practice of naming variable so here firstName == first_name on database ...
// and then no need to use @column and the name, but it prefers doing both
import jakarta.persistence.*;

@Entity // map this class into database table
@Table(name = "student") // name of database table
public class Student {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // let database handel auto increment
    @Column(name = "id") // the name of column in database
    private int id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email    ;

    public Student () {

    }
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
