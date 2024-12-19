package com.example.demo_app.controller;

import com.example.demo_app.modele.animal;
import com.example.demo_app.repository.AnimalRepository;
import com.example.demo_app.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<animal> findAll() {
        return this.animalService.findAll();
    }
    
    @GetMapping("/page")
    public Page<animal> findPage(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return this.animalService.findPage(pageable);
    }
}