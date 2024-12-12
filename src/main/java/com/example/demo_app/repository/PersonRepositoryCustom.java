package com.example.demo_app.repository;

import com.example.demo_app.modele.person;

import java.util.List;

public interface PersonRepositoryCustom {
    public void supprimerPersonnerSansAnimaux();
    public void genererEntites(Integer NbPersonne);
}
