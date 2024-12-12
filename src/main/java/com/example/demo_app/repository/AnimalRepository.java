package com.example.demo_app.repository;
import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.person;
import com.example.demo_app.modele.species;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository

public interface AnimalRepository extends CrudRepository<animal, Integer> {
    public animal findFirstById(Integer id);
    public Set<animal> findAll();
    @Query("From animal WHERE name = :name")
    public Set<animal> findAllByName(@Param("name") String name);
    @Query("From animal a INNER JOIN a.specie s WHERE s = :Espece")
    public Set<animal> findAllBySpecie(@Param("Espece") species Espece);
    @Query("From animal WHERE color in :listeCouleur")
    public Set<animal> findAllByColorIn(@Param("listeCouleur") Set<String> listeCouleur);

    @Query("select count (*) FROM animal WHERE sex = :Sex")
    public Integer countAllBySex(@Param("Sex") String Sex);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM person p JOIN p.animals a WHERE a = :animal")
    boolean existsByAnimal(@Param("animal") animal animal);
}