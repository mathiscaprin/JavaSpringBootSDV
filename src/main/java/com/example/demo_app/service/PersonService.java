package com.example.demo_app.service;

import com.example.demo_app.exceptions.EntityToCreateHasAnIdException;
import com.example.demo_app.exceptions.EntityToUpdateHasNoIdException;
import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.person;
import com.example.demo_app.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public person create(@Valid person personToCreate) {
        if (personToCreate.getId() != null){
            throw new EntityToCreateHasAnIdException("la personne ne doit pas avoir d'id");

        }else{
            return this.personRepository.save(personToCreate);
        }
    }
    public person update(@Valid person updatedPerson) {
        findById(updatedPerson.getId());

        if (updatedPerson.getId() == null){
            throw new EntityToUpdateHasNoIdException("la personne doit avoir un id");
        }else{
            return this.personRepository.save(updatedPerson);
        }
    }
    public void delete(@Valid person deletedPerson) {
        findById(deletedPerson.getId());

        this.personRepository.delete(deletedPerson);
    }
   public List<person> findAll() {
        return this.personRepository.findAll();
    }
    public person findById(Integer id) {
        return this.personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public Page<person> findPage(Pageable pageable) {
        return this.personRepository.findAll(pageable);
    }
}