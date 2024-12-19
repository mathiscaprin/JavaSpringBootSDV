package com.example.demo_app.repository;

import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<person,Integer>, PersonRepositoryCustom {
    @Query("From person WHERE firstname = :firstname AND lastname = :lastName")
    public List<person> findAllByFirstnameOrLastname(@Param("firstname") String firstName, @Param("lastName") String lastName);
    @Query("From person WHERE age = :age")
    public List<person> findAllByAgeIsAfter(@Param("age") Integer Age);

    @Query("from person where age > :AgeMin AND age < :AgeMax")
    public List<person> findAllByAgeBetween(@Param("AgeMin") Integer AgeMin, @Param("AgeMax") Integer AgeMax);

    @Query("from person p INNER JOIN p.animals a where a = :Animal")
    public List<person> findAllByAnimals(@Param("Animal") animal Animal);
}
