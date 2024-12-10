package com.example.demo_app.modele;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "animal")
public class animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(50)", nullable = true)
    private String color;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String sex;

    @ManyToMany
    @JoinTable(
            name = "person_animals",
            joinColumns = @JoinColumn(name = "animals_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    Set<person> linkedPerson;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species_id", insertable = false, updatable = false)
    private species specie;
}
