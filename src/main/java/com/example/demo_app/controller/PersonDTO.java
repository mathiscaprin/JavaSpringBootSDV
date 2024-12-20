package com.example.demo_app.controller;

import com.example.demo_app.modele.animal;

import java.util.List;

public class PersonDTO {

    private Integer id;
    private String name;
    private Integer age;
    private String[] animals;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getAnimals() {
        return animals;
    }

    public void setAnimals(String[] animals) {
        this.animals = animals;
    }
}
