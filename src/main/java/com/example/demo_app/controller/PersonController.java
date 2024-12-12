package com.example.demo_app.controller;

import com.example.demo_app.modele.person;
import com.example.demo_app.repository.PersonRepository;
import com.example.demo_app.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/person")
public class PersonController {
    @Autowired
    private PersonService personService = new PersonService();
    @PostMapping
    public person createPerson(@RequestBody @Valid person personToCreate) {
        return this.personService.create(personToCreate);
    }
    @PutMapping
    public person updatePerson(@RequestBody @Valid person updatedPerson) {
        return this.personService.update(updatedPerson);
    }
    @DeleteMapping("/{id}")
    public void DeletePerson(@PathVariable("id") person deletetedPerson) {
        this.personService.delete(deletetedPerson);
    }
    @GetMapping("/{id}")
    public person findOne(@PathVariable("id") Integer id) {
        return this.personService.findById(id);
    }

    @GetMapping
    public Set<person> findAll() {
        return this.personService.findAll();
    }
}