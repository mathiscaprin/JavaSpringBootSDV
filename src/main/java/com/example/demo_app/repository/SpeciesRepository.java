package com.example.demo_app.repository;

import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpeciesRepository extends JpaRepository<species,Integer> {


    @Query("From species WHERE commonName = :CommonName")
    public species findFirstByCommonName(@Param("CommonName") String CommonName);
    @Query("From species WHERE latinName = :LatinName")
    public List<species> findAllByLatinNameContainsIgnoreCase(@Param("LatinName") String LatinName);

    @Query("From species ORDER BY commonName ASC")
    public List<species> getAllByCommonName();

   @Query("FROM species WHERE commonName LIKE :CommonName")
   public List<species> findAllByCommonNameLike(@Param("CommonName") String CommonName);




}
