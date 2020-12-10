package com.lambdaschool.zoos;


import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.services.AnimalService;
import com.lambdaschool.zoos.services.TelephoneService;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



@Transactional
@Component
public class SeedData
		implements CommandLineRunner {

	private final Random           random = new Random();
	private final AnimalService    animalService;
	private final ZooService       zooService;
	private final TelephoneService phoneService;

	@Autowired
	public SeedData(
			AnimalService animalService,
			ZooService zooService,
			TelephoneService phoneService
	) {
		this.animalService = animalService;
		this.zooService    = zooService;
		this.phoneService  = phoneService;
	}

	@Transactional
	@Override
	public void run(String... args)
			throws
			Exception {
		Animal a1 = new Animal("lion");
		Animal a2 = new Animal("bear");
		Animal a3 = new Animal("monkey");
		Animal a4 = new Animal("penguin");
		Animal a5 = new Animal("tiger");
		Animal a6 = new Animal("llama");
		Animal a7 = new Animal("turtle");
		Zoo    z1 = new Zoo("Gladys Porter Zoo");
		Zoo    z2 = new Zoo("Point Defiance Zoo");
		Zoo    z3 = new Zoo("San Diego Zoo");
		Zoo    z4 = new Zoo("San Antonio Zoo");
		Zoo    z5 = new Zoo("Smithsonian Zoo");
		a1.getZoos()
		  .add(new ZooAnimals(
				  a1,
				  z1
		  ));
		a2.getZoos()
		  .add(new ZooAnimals(
				  a2,
				  z1,
				  "Point Defiance Zoo"
		  ));
		a2.getZoos()
		  .add(new ZooAnimals(
				  a2,
				  z2
		  ));
		a5.getZoos()
		  .add(new ZooAnimals(
				  a5,
				  z5
		  ));
		a6.getZoos()
		  .add(new ZooAnimals(
				  a6,
				  z5
		  ));
		a7.getZoos()
		  .add(new ZooAnimals(
				  a7,
				  z5
		  ));
		a1.getZoos()
		  .add(new ZooAnimals(
				  a1,
				  z5
		  ));
		a1.getZoos()
		  .add(new ZooAnimals(
				  a1,
				  z3
		  ));
		a2.getZoos()
		  .add(new ZooAnimals(
				  a2,
				  z3
		  ));
		Telephone p1 = new Telephone(
				"MAIN",
				"1234567",
				z1
		);
		Telephone p2 = new Telephone(
				"MAIN",
				"1234567",
				z2
		);
		Telephone p3 = new Telephone(
				"MAIN",
				"1234567",
				z3
		);
		Telephone p4 = new Telephone(
				"MAIN",
				"1234567",
				z4
		);
		Telephone p5 = new Telephone(
				"MAIN",
				"1234567",
				z5
		);
		Telephone p6 = new Telephone(
				"EDUCATION",
				"1234567",
				z1
		);



		zooService.saveAll(new ArrayList<Zoo>(Arrays.asList(
				z1,
				z2,
				z3,
				z4,
				z5
		)));
		animalService.save(a1);
		List<Animal> animalList = new ArrayList<>(Arrays.asList(
				a2,
				a3,
				a4,
				a5,
				a6,
				a7
		));
		animalService.saveAll(animalList);

		phoneService.saveAll(new ArrayList<Telephone>(Arrays.asList(
				p1,
				p2,
				p3,
				p4,
				p5,
				p6
		)));


	}

}
