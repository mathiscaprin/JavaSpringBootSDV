package com.example.demo_app.modele;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "species")
public class species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(columnDefinition = "varchar(50)", nullable = false, name = "common_name")
    public String commonName;
    @Column(columnDefinition = "varchar(50)", nullable = false, name = "latin_name")
    public String latinName;

    @OneToMany(mappedBy = "specie")
    private Set<animal> animals;

}
