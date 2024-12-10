package com.example.demo_app.repository;
import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.person;
import com.example.demo_app.modele.species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository

public interface AnimalRepository extends CrudRepository<animal, Integer> {
    public Set<animal> findAllByName(String name);
    public Set<animal> findAllBySpecie(species espece);

    public Set<animal> findAllByColorIn(Set<String> listeCouleur);
}