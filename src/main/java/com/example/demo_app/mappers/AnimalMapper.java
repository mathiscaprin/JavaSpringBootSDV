package com.example.demo_app.mappers;

import com.example.demo_app.controller.AnimalDTO;
import com.example.demo_app.controller.PersonDTO;
import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.person;
import com.example.demo_app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AnimalMapper {

    @Autowired
    PersonRepository personRepository = null;
    public AnimalDTO toDto(animal animal) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        dto.setSpecies(animal.getSpecie().commonName);
        List<person> personnes = personRepository.findAllByAnimals(animal);
        StringBuilder persons = new StringBuilder();
        for (person p : personnes) {
            persons.append(p.getLastname()).append(" ").append(p.getFirstname()).append(", ");
        }
        dto.setPerson(persons.toString());
        
        return dto;
    }
}
