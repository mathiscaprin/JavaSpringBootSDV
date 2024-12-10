package com.example.demo_app.repository;

import com.example.demo_app.modele.person;
import com.example.demo_app.modele.species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonRepository extends CrudRepository<person,Integer> {
    public Set<person> findAllByFirstnameOrLastname(String FirstName, String LastName);

    public Set<person> findAllByAgeIsAfter(Integer Age);
}
