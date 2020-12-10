package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Telephone;

import java.util.List;



public interface TelephoneService {
	Telephone save(Telephone telephone);
	List<Telephone> saveAll(List<Telephone> phones);
	void delete(long id);
	void deleteAll();
//	Telephone update(long phoneid, Telephone phone);
	List<Telephone> findAllTelephones();
}
