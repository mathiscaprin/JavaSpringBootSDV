package com.example.demo_app.service;

import com.example.demo_app.modele.person;
import com.example.demo_app.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Set;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public person create(@Valid person personToCreate) { return
            this.personRepository.save(personToCreate);
    }
    public person update(@Valid person updatedPerson) { return
            this.personRepository.save(updatedPerson);
    }
    public void delete(@Valid person deletedPerson) {
            this.personRepository.delete(deletedPerson);
    }
   public Set<person> findAll() {
        return this.personRepository.findAll();
    }
    public person findById(Integer id) {
        return this.personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}