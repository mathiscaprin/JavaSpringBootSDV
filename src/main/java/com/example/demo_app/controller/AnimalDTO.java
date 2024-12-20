package com.example.demo_app.controller;

public class AnimalDTO {
    private Integer id;
    private String name;
    private String species;
    private String color;
    private String persons;

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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPerson() {
        return persons;
    }

    public void setPerson(String person) {
        this.persons = person;
    }
}
