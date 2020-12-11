package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.repos.AnimalRepo;
import com.lambdaschool.zoos.repos.TelephoneRepo;
import com.lambdaschool.zoos.repos.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Transactional
@Service(value = "zooService")
public class ZooServiceImpl
		implements ZooService {
	private final ZooRepo       zooRepo;
	private final TelephoneRepo phoneRepo;
	private final AnimalRepo    animalRepo;

	@Autowired
	public ZooServiceImpl(
			ZooRepo zooRepo,
			TelephoneRepo phoneRepo,
			AnimalRepo animalRepo
			) {
		this.zooRepo    = zooRepo;
		this.phoneRepo  = phoneRepo;
		this.animalRepo = animalRepo;
	}

	@Override
	public List<Zoo> findAllZoos() {
		List<Zoo> zoos = new ArrayList<>();
		zooRepo.findAll()
		       .iterator()
		       .forEachRemaining(zoos::add);
		return zoos;
	}

	@Transactional
	@Override
	public Zoo save(Zoo zoo) {
		Zoo newZoo = new Zoo();
		if (zoo.getZooid() != 0) {
			zooRepo.findById(zoo.getZooid())
			       .orElseThrow(() -> new EntityNotFoundException("Zoo " + zoo.getZooid() + " Not Found"));
			newZoo.setZooid(zoo.getZooid());
		}
		newZoo.setZooname(zoo.getZooname());


		newZoo.getTelephones()
		      .clear();

		for (Telephone t : zoo.getTelephones()) {
			Telephone           newPhone;
			Optional<Telephone> optionalTelephone = phoneRepo.findById(t.getPhoneid());
			if (optionalTelephone.isPresent()) {
				newPhone = optionalTelephone.get();
			} else {
				newPhone = new Telephone();
				if (t.getPhonetype() != null) {
					newPhone.setPhonetype(t.getPhonetype());
				}
				if (t.getPhonenumber() != null) {
					newPhone.setPhonetype(t.getPhonetype());
				}

				newPhone.setZoo(newZoo);
			}

			phoneRepo.save(newPhone);
			newZoo.getTelephones()
			      .add(newPhone);
		}
		newZoo.getAnimals()
		      .clear();
		for (ZooAnimals za : zoo.getAnimals()) {
			if (za.getZoo()
			      .getZooid() == newZoo.getZooid()) {
				Animal           a              = za.getAnimal();
				Animal           newAnimal;
				Optional<Animal> optionalAnimal = animalRepo.findById(a.getAnimalid());
				if (optionalAnimal.isPresent()) {
					newAnimal = optionalAnimal.get();
				} else {
					newAnimal = new Animal();
					if (a.getAnimaltype() != null) {
						newAnimal.setAnimaltype(a.getAnimaltype());
					}
				}

				//			newAnimal.getZoos().add(new ZooAnimals(newAnimal, newZoo));
				newZoo.getAnimals()
				      .add(new ZooAnimals(
						      newAnimal,
						      newZoo
				      ));
				animalRepo.save(newAnimal);
			}

		}

		return zooRepo.save(newZoo);
	}

	@Transactional
	@Override
	public List<Zoo> saveAll(List<Zoo> zoos) {
		List<Zoo> savedZoos = new ArrayList<>();
		for (Zoo z : zoos) {
			savedZoos.add(this.save(z));
		}
		return savedZoos;
	}

	@Transactional
	@Override
	public Zoo update(
			long zooid,
			Zoo zoo
	) {
		return null;
	}

	@Transactional
	@Override
	public void delete(long id) {
		zooRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() {
		zooRepo.deleteAll();
	}

	@Override
	public Zoo findZoo(long zooid) {
		return zooRepo.findById(zooid)
		              .orElseThrow(() -> new EntityNotFoundException("Zoo " + zooid + " Not Found"));
	}

}
