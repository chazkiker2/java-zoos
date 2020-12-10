package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCountView;

import java.util.List;



public interface AnimalService {
	Animal save(Animal animal);

	List<Animal> saveAll(List<Animal> animals);

	List<Animal> findAllAnimals();

	List<AnimalCountView> findAnimalZooCounts();

	void delete(long id);
	void deleteAll();
}
