package com.lambdaschool.zoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "animals")
public class Animal
		extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long animalid;

	@Column(nullable = false,
	        unique = true)
	private String animaltype;

	@OneToMany(mappedBy="zoo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value= {"zoo", "telephone"}, allowSetters = true)
	private Set<ZooAnimals> zoos = new HashSet<>();

	public Animal() {}

//	@Autowired
	public Animal(
//			long animalid,
			String animaltype
	) {
//		this.animalid   = animalid;
		this.animaltype = animaltype;
	}

	public long getAnimalid() {
		return animalid;
	}

	public void setAnimalid(long animalid) {
		this.animalid = animalid;
	}

	public String getAnimaltype() {
		return animaltype;
	}

	public void setAnimaltype(String animaltype) {
		this.animaltype = animaltype;
	}

	public Set<ZooAnimals> getZoos() {
		return zoos;
	}

	public void setZoos(Set<ZooAnimals> zoos) {
		this.zoos = zoos;
	}

	@Override
	public String toString() {
		return "Animal{" + "animalid=" + animalid + ", animaltype='" + animaltype + '\'' + '}';
	}



}
