package com.example.demo_app.controller;

import com.example.demo_app.modele.species;
import com.example.demo_app.repository.SpeciesRepository;
import com.example.demo_app.service.SpecieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {
    @Autowired
    private SpecieService speciesService;
    @PostMapping
    public species createSpecies(@RequestBody @Valid species speciesToCreate) {
        return this.speciesService.create(speciesToCreate);
    }
    @PutMapping
    public species updateSpecies(@RequestBody @Valid species updatedSpecies) {
        return this.speciesService.update(updatedSpecies);
    }
    @DeleteMapping("/{id}")
    public void DeleteSpecies(@PathVariable("id") species deletetedSpecies) {
        this.speciesService.delete(deletetedSpecies);
    }
    @GetMapping("/{id}")
    public species findOne(@PathVariable("id") Integer id) {
        return this.speciesService.findById(id);
    }

    @GetMapping
    public Set<species> findAll() {
        return this.speciesService.findAll();
    }
}