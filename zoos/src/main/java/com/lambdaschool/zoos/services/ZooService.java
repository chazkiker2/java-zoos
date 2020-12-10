package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Zoo;

import java.util.List;



public interface ZooService {
	Zoo save(Zoo zoo);

	List<Zoo> saveAll(List<Zoo> zoos);

	Zoo update(
			long zooid,
			Zoo zoo
	);

	Zoo findZoo(long zooid);

	List<Zoo> findAllZoos();

	void delete(long id);

	void deleteAll();

}
