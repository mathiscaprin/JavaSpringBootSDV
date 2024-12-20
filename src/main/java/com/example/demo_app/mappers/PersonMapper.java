package com.example.demo_app.mappers;

import com.example.demo_app.controller.PersonDTO;
import com.example.demo_app.service.PersonService;
import org.springframework.stereotype.Component;
import com.example.demo_app.modele.person;

@Component
public class PersonMapper {
    // Transformer une Person en PersonDto
    public PersonDTO toDto(person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setAge(person.getAge());
        dto.setName(person.getLastname() + " " + person.getFirstname());
        String[] animals = new String[person.getAnimals().size()];
        person.getAnimals().forEach(animal -> {
            animals[person.getAnimals().indexOf(animal)] = animal.getName();
        });
        dto.setAnimals(animals);
        return dto;
    }
}