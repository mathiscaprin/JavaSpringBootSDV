package com.example.demo_app.service;

import com.example.demo_app.modele.animal;
import com.example.demo_app.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Set;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    public animal create(@Valid animal animalToCreate) { return
            this.animalRepository.save(animalToCreate);
    }
    public animal update(@Valid animal updatedAnimal) { return
            this.animalRepository.save(updatedAnimal);
    }
    public void delete(@Valid animal deletedAnimal) {
        this.animalRepository.delete(deletedAnimal);
    }
    public Set<animal> findAll() {
        return this.animalRepository.findAll();
    }
    public animal findById(Integer id) {
        return this.animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}