package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.repos.AnimalRepo;
import com.lambdaschool.zoos.views.AnimalCountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Transactional
@Service(value = "animalService")
public class AnimalServiceImpl
		implements AnimalService {
	private final AnimalRepo animalRepo;

	@Autowired
	public AnimalServiceImpl(AnimalRepo animalRepo) {
		this.animalRepo = animalRepo;
	}

	@Transactional
	@Override
	public List<Animal> saveAll(List<Animal> animals) {
		List<Animal> createdAnimals = new ArrayList<>();
		animals.stream()
		       .iterator()
		       .forEachRemaining((animal) -> {
			       createdAnimals.add(this.save(animal));
		       });
		return createdAnimals;
	}

	@Transactional
	@Override
	public Animal save(Animal animal) {
		return animalRepo.save(animal);
	}

	@Override
	public List<Animal> findAllAnimals() {
		List<Animal> animals = new ArrayList<>();
		animalRepo.findAll()
		          .iterator()
		          .forEachRemaining(animals::add);
		return animals;
	}

	@Transactional
	@Override
	public void delete(long id) {
		animalRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() {
		animalRepo.deleteAll();
	}

	@Override
	public List<AnimalCountView> findAnimalZooCounts() {
		return animalRepo.getAnimalZooCount();
		//		return new ArrayList<AnimalCountView>(animalRepo.getAnimalZooCount());
	}

}
