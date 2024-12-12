package com.example.demo_app.repository;

import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonRepository extends CrudRepository<person,Integer>, PersonRepositoryCustom {
    @Query("From person WHERE firstname = :firstname AND lastname = :lastName")
    public Set<person> findAllByFirstnameOrLastname(@Param("firstname") String firstName, @Param("lastName") String lastName);
    @Query("From person WHERE age = :age")
    public Set<person> findAllByAgeIsAfter(@Param("age") Integer Age);

    @Query("from person where age > :AgeMin AND age < :AgeMax")
    public Set<person> findAllByAgeBetween(@Param("AgeMin") Integer AgeMin, @Param("AgeMax") Integer AgeMax);

    @Query("from person p INNER JOIN p.animals a where a = :Animal")
    public Set<person> findAllByAnimals(@Param("Animal") animal Animal);
}
