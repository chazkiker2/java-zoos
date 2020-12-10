package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.repos.TelephoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;



@Transactional
@Service(value = "telephoneService")
public class TelephoneServiceImpl
		implements TelephoneService {
	private TelephoneRepo phoneRepo;

	@Autowired
	public TelephoneServiceImpl(TelephoneRepo phoneRepo) {
		this.phoneRepo = phoneRepo;
	}

	@Transactional
	@Override
	public Telephone save(Telephone telephone) {
		return phoneRepo.save(telephone);
	}

	@Transactional
	@Override
	public List<Telephone> saveAll(List<Telephone> phones) {
		List<Telephone> savedPhones = new ArrayList<>();
		for (Telephone t : phones) {
			savedPhones.add(this.save(t));
		}
		return savedPhones;
	}

	@Transactional
	@Override
	public void delete(long id) {
		phoneRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() {
		phoneRepo.deleteAll();
	}

//	@Transactional
//	@Override
//	public Telephone update(
//			long phoneid,
//			Telephone phone
//	) {
//		if (phone.getPhonenumber() == null) {
//			throw new EntityNotFoundException("No phonenumber");
//		}
//		if (phone.getPhonetype() == null) {
//			throw new EntityNotFoundException("No phone type");
//		}
//		phoneRepo.findById(phoneid)
//		         .orElseThrow(() -> new EntityNotFoundException("Phone id " + phoneid + " Not Found"));
//
//		phoneRepo.updatePhone(
//				phoneid,
//				phone.getPhonenumber(),
//				phone.getPhonetype(),
//				"SYSTEM"
//		);
//
//		return phoneRepo.findById(phoneid)
//		                .orElseThrow(() -> new EntityNotFoundException("Phone id " + phoneid + " Not Found"));
//
//	}

	@Override
	public List<Telephone> findAllTelephones() {
		return null;
	}

}
