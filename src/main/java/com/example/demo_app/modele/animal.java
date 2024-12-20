package com.example.demo_app.modele;

import jakarta.persistence.*;
import org.springframework.core.style.ToStringCreator;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id", insertable = false, updatable = false)

    private species specie;


    @Override
    public String toString() {
        return "animal{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public species getSpecie() {
        return specie;
    }
}
