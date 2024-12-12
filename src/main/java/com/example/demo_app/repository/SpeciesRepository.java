package com.example.demo_app.repository;

import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.species;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SpeciesRepository extends CrudRepository<species,Integer> {

    public Set<species> findAll();
    @Query("From species WHERE commonName = :CommonName")
    public species findFirstByCommonName(@Param("CommonName") String CommonName);
    @Query("From species WHERE latinName = :LatinName")
    public Set<species> findAllByLatinNameContainsIgnoreCase(@Param("LatinName") String LatinName);

    @Query("From species ORDER BY commonName ASC")
    public Set<species> getAllByCommonName();

   @Query("FROM species WHERE commonName LIKE :CommonName")
   public Set<species> findAllByCommonNameLike(@Param("CommonName") String CommonName);




}
