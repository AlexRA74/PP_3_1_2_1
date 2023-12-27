package ru.javamentor.springmvc.model;


import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Name should be between 2 and 25 latin characters")
    @Size(min = 2, max = 25)
    private String name;

    @Column(name = "lastName")
    @NotEmpty(message = "Name should be between 2 and 25 latin characters")
    @Size(min = 2, max = 25)
    private String lastName;

    @Column
    @Min(value = 0, message = "Age should be >= 0")
    @Max(value = 127, message = "Age should be < 128")
    private Short age;

    public User() {

    }

    public User(String name, String lastName, Short age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User {id = '%s', name = '%s', lastName = '%s', age = '%d'}", getId(), getName(), getLastName(), getAge());
    }
}
