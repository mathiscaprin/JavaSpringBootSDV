package com.example.demo_app;

import com.example.demo_app.modele.animal;
import com.example.demo_app.modele.species;
import com.example.demo_app.repository.AnimalRepository;
import com.example.demo_app.repository.PersonRepository;
import com.example.demo_app.repository.SpeciesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
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
		species spicies =  this.speciesRepository.findFirstByCommonName("Chien");
		animal animal = this.animalRepository.findFirstById(1);
		/*System.out.println("Toutes les entités Person : " + this.personRepository.findAll());
		System.out.println("Animal par lastname : " + this.animalRepository.findAllByName("Loulou"));
		System.out.println("Espèce par name : " + this.speciesRepository.findFirstByCommonName("Chien"));
		System.out.println("Espèce par latinname : " + this.speciesRepository.findAllByLatinNameContainsIgnoreCase("lupus"));
		System.out.println("Personne par commonname ou lastname : " + this.personRepository.findAllByFirstnameOrLastname("Jeancc","Lamarque"));
		System.out.println("Personne par age : " + this.personRepository.findAllByAgeIsAfter(50));

		System.out.println("Animal par espèce : " + this.animalRepository.findAllBySpecie(spicies));
		System.out.println("Animal par couleur : " + this.animalRepository.findAllByColorIn(Set.of("Noir","BLanc")));
		System.out.println("Persone par age : " + this.personRepository.findAllByAgeBetween(20,30));
		System.out.println("Persone par animal : " + this.personRepository.findAllByAnimals(animal));
		System.out.println("Toutes espece trié par commonname : " + this.speciesRepository.getAllByCommonName());
		System.out.println("Toutes espece LIKE commonName: " + this.speciesRepository.findAllByCommonNameLike("Ch%"));

		System.out.println("Animal par sex : " + this.animalRepository.countAllBySex("M"));
		System.out.println("Appartient à une personne : " + this.animalRepository.existsByAnimal(animal));*/
		//this.personRepository.supprimerPersonnerSansAnimaux();
		//this.personRepository.genererEntites(3);
		System.out.println("toutes les personnes : " + this.personRepository.findAll());


	}
}
