package com.example.demo_app.service;

import com.example.demo_app.exceptions.EntityToCreateHasAnIdException;
import com.example.demo_app.exceptions.EntityToUpdateHasNoIdException;
import com.example.demo_app.modele.animal;
import com.example.demo_app.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    public animal create(@Valid animal animalToCreate) {
        if (animalToCreate.getId() != null){
            throw new EntityToCreateHasAnIdException("l'animal ne doit pas avoir d'id");
        }else{
            return this.animalRepository.save(animalToCreate);
        }
    }
    public animal update(@Valid animal updatedAnimal) {
        findById(updatedAnimal.getId());
        if (updatedAnimal.getId() == null){
            throw new EntityToUpdateHasNoIdException("l'animal doit avoir un id");
        }else{
            return this.animalRepository.save(updatedAnimal);
        }
    }
    public void delete(@Valid animal deletedAnimal) {
        findById(deletedAnimal.getId());
        this.animalRepository.delete(deletedAnimal);
    }
    public List<animal> findAll() {
        return (List<animal>) this.animalRepository.findAll();
    }
    public animal findById(Integer id) {
        return this.animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public Page<animal> findPage(Pageable pageable) {
        return this.animalRepository.findAll(pageable);
    }
}