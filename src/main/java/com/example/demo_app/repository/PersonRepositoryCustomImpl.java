package com.example.demo_app.repository;

import com.example.demo_app.modele.person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.random.RandomGenerator;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void supprimerPersonnerSansAnimaux() {
        //em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM person WHERE animals IS EMPTY");
        query.executeUpdate();
        //em.getTransaction().commit();
    }

    @Override
    @Transactional
    public void genererEntites(Integer NbPersonne) {
        for (int i = 0; i < NbPersonne; i++){
            person p = new person();
            p.setFirstname("Mister " + i);
            p.setLastname("Doe " + i);
            em.persist(p);
        }
    }

}
