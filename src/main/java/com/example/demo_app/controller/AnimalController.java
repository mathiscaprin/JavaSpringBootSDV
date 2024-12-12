package com.example.demo_app.controller;

import com.example.demo_app.modele.animal;
import com.example.demo_app.repository.AnimalRepository;
import com.example.demo_app.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService = new AnimalService();
    @PostMapping
    public animal createAnimal(@RequestBody @Valid animal animalToCreate) {
        return this.animalService.create(animalToCreate);
    }
    @PutMapping
    public animal updateAnimal(@RequestBody @Valid animal updatedAnimal) {
        return this.animalService.update(updatedAnimal);
    }
    @DeleteMapping("/{id}")
    public void DeleteAnimal(@PathVariable("id") animal deletetedAnimal) {
        this.animalService.delete(deletetedAnimal);
    }
    @GetMapping("/{id}")
    public animal findOne(@PathVariable("id") Integer id) {
        return this.animalService.findById(id);
    }

    @GetMapping
    public Set<animal> findAll() {
        return this.animalService.findAll();
    }
}