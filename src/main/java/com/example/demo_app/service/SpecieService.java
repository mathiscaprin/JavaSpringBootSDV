package com.example.demo_app.service;

import com.example.demo_app.exceptions.EntityToCreateHasAnIdException;
import com.example.demo_app.exceptions.EntityToUpdateHasNoIdException;
import com.example.demo_app.modele.person;
import com.example.demo_app.modele.species;
import com.example.demo_app.repository.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpecieService {
    @Autowired
    SpeciesRepository speciesRepository;
    public species create(@Valid species speciesToCreate) {
        if (speciesToCreate.getId() != null){
            throw new EntityToCreateHasAnIdException("l'espece ne doit pas avoir d'id");
        }else{
            return this.speciesRepository.save(speciesToCreate);
        }
    }
    public species update(@Valid species updatedSpecies) {
        findById(updatedSpecies.getId());

        if (updatedSpecies.getId() == null){
            throw new EntityToUpdateHasNoIdException("l'espece doit avoir un id");
        }else{
            return this.speciesRepository.save(updatedSpecies);
        }
    }
    public void delete(@Valid species deletedSpecies) {
        findById(deletedSpecies.getId());
        this.speciesRepository.delete(deletedSpecies);
    }
    public List<species> findAll() {
        return this.speciesRepository.findAll();
    }
    public species findById(Integer id) {
        return this.speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public Page<species> findPage(Pageable pageable) {
        return this.speciesRepository.findAll(pageable);
    }
}
