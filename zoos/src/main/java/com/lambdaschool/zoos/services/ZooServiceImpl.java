package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repos.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;



@Transactional
@Service(value = "zooService")
public class ZooServiceImpl
		implements ZooService {
	private final ZooRepo zooRepo;

	@Autowired
	public ZooServiceImpl(ZooRepo zooRepo) {
		this.zooRepo = zooRepo;
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
		return zooRepo.save(zoo);
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
