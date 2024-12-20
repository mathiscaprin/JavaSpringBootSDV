package com.example.demo_app.service;

import com.example.demo_app.controller.AnimalDTO;
import com.example.demo_app.controller.PersonDTO;
import com.example.demo_app.exceptions.EntityToCreateHasAnIdException;
import com.example.demo_app.exceptions.EntityToUpdateHasNoIdException;
import com.example.demo_app.mappers.AnimalMapper;
import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.person;
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
    @Autowired
    AnimalMapper animalMapper;
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
    public List<AnimalDTO> findAll() {
        List<animal> animals = this.animalRepository.findAll();
        List<AnimalDTO> animalsDTO = new java.util.ArrayList<>();
        animals.forEach(animal -> {
            animalsDTO.add(animalMapper.toDto(animal));
        });
        return animalsDTO;
    }
    public animal findById(Integer id) {
        return this.animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public Page<AnimalDTO> findPage(Pageable pageable) {
        Page<animal> animals = this.animalRepository.findAll(pageable);
        return animals.map(
                animal -> animalMapper.toDto(animal)
        );
    }
}