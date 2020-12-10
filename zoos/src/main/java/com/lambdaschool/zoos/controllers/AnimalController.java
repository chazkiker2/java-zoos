package com.lambdaschool.zoos.controllers;


import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.dtos.AnimalCountDto;
import com.lambdaschool.zoos.services.AnimalService;
import com.lambdaschool.zoos.views.AnimalCountView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/animals/")
public class AnimalController {
	private AnimalService animalService;

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping(value = "all", produces = "application/json")
	public ResponseEntity<?> listAllZoos() {
		List<Animal> animals =  animalService.findAllAnimals();
		return new ResponseEntity<>(animals, HttpStatus.OK);
	}

	@GetMapping(value="count", produces="application/json")
	public ResponseEntity<?> listAnimalZooCount() {
		List<AnimalCountView> animalCountViews = animalService.findAnimalZooCounts();
		return new ResponseEntity<>(animalCountViews, HttpStatus.OK);
	}



	private AnimalCountDto convertToCountDto(Animal animal) {
		return modelMapper.map(animal, AnimalCountDto.class);
	}


}
