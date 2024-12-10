package com.example.demo_app.modele;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "person")
public class person {
    @Id
    public Integer id;

    @Column(columnDefinition = "int", nullable = true)
    public Integer age;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    public String firstname;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    public String lastname;

    @ManyToMany(mappedBy = "linkedPerson")
    Set<animal> animals;

}
