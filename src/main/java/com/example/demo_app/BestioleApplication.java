package com.example.demo_app;

import com.example.demo_app.modele.species;
import com.example.demo_app.repository.AnimalRepository;
import com.example.demo_app.repository.PersonRepository;
import com.example.demo_app.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BestioleApplication implements CommandLineRunner {


	private PersonRepository personRepository;
	private AnimalRepository animalRepository;
	private SpeciesRepository speciesRepository;
	@Autowired
	public BestioleApplication(PersonRepository personRepository, AnimalRepository animalRepository, SpeciesRepository speciesRepository) {
		this.personRepository = personRepository;
		this.animalRepository = animalRepository;
		this.speciesRepository = speciesRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BestioleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Toutes les entités Person : " + this.personRepository.findAll());
		System.out.println("Animal par lastname : " + this.animalRepository.findAllByName("Loulou"));
		System.out.println("Espèce par name : " + this.speciesRepository.findFirstByCommonName("Chien"));
		System.out.println("Espèce par latinname : " + this.speciesRepository.findAllByLatinNameContainsIgnoreCase("lupus"));
		System.out.println("Personne par commonname ou lastname : " + this.personRepository.findAllByFirstnameOrLastname("Jeancc","Lamarque"));
		System.out.println("Personne par age : " + this.personRepository.findAllByAgeIsAfter(50));
		species spicies =  this.speciesRepository.findFirstByCommonName("Chien");

		System.out.println("Animal par espèce : " + this.animalRepository.findAllBySpecie(spicies));
		System.out.println("Animal par couleur : " + this.animalRepository.findAllByColorIn(Set.of("Noir","BLanc")));

	}
}
