package com.example.demo_app.repository;
import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.species;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository

public interface AnimalRepository extends JpaRepository<animal, Integer> {
    public animal findFirstById(Integer id);
    @Query("From animal WHERE name = :name")
    public List<animal> findAllByName(@Param("name") String name);
    @Query("From animal a INNER JOIN a.specie s WHERE s = :Espece")
    public List<animal> findAllBySpecie(@Param("Espece") species Espece);
    @Query("From animal WHERE color in :listeCouleur")
    public List<animal> findAllByColorIn(@Param("listeCouleur") List<String> listeCouleur);

    @Query("select count (*) FROM animal WHERE sex = :Sex")
    public Integer countAllBySex(@Param("Sex") String Sex);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM person p JOIN p.animals a WHERE a = :animal")
    boolean existsByAnimal(@Param("animal") animal animal);

}