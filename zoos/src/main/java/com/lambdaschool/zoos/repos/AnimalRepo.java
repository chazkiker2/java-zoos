package com.lambdaschool.zoos.repos;


import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCountView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



public interface AnimalRepo
		extends CrudRepository<Animal, Long> {
	@Query(value = "SELECT count(distinct za.animalid) as zoocount, a.animaltype as animaltype, a.animalid as animalid " +
	               "FROM animals a LEFT JOIN zooanimals za ON a.animalid = za.animalid GROUP BY a.animaltype, a.animalid",
	       nativeQuery = true)
	List<AnimalCountView> getAnimalZooCount();

}
