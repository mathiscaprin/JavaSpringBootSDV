package com.example.demo_app.repository;

import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SpeciesRepository extends CrudRepository<species,Integer> {
    public species findFirstByCommonName(String CommonName);

    public Set<species> findAllByLatinNameContainsIgnoreCase(String LatinName);


}
