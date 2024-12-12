package com.example.demo_app.service;

import com.example.demo_app.modele.species;
import com.example.demo_app.repository.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SpecieService {
    @Autowired
    SpeciesRepository speciesRepository;
    public species create(@Valid species speciesToCreate) { return
            this.speciesRepository.save(speciesToCreate);
    }
    public species update(@Valid species updatedSpecies) { return
            this.speciesRepository.save(updatedSpecies);
    }
    public void delete(@Valid species deletedSpecies) {
        this.speciesRepository.delete(deletedSpecies);
    }
    public Set<species> findAll() {
        return this.speciesRepository.findAll();
    }
    public species findById(Integer id) {
        return this.speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
