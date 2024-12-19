package com.example.demo_app.modele;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "person")
public class person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int", nullable = true)
    private Integer age;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String firstname;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String lastname;

    @ManyToMany(mappedBy = "linkedPerson", fetch = FetchType.EAGER)
    Set<animal> animals;

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", age=" + age +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", animals=" + animals +
                '}';
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}