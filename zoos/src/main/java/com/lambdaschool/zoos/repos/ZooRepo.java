package com.lambdaschool.zoos.repos;


import com.lambdaschool.zoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;



public interface ZooRepo extends CrudRepository<Zoo, Long> {}
