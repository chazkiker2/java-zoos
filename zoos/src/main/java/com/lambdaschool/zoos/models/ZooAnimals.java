package com.lambdaschool.zoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals
		extends Auditable
		implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "animalid")
	@JsonIgnoreProperties(value = "zoos",
	                      allowSetters = true)
	private Animal animal;

	@Id
	@ManyToOne
	@JoinColumn(name = "zooid")
	@JsonIgnoreProperties(value = "animals",
	                      allowSetters = true)
	private Zoo zoo;

	@Column(nullable = true,
	        unique = false)
	private String incomingzoo;

	public ZooAnimals() {}

	public ZooAnimals(Animal animal, Zoo zoo) {
		this.animal = animal;
		this.zoo = zoo;
		this.incomingzoo = null;
	}

	public ZooAnimals(
			Animal animal,
			Zoo zoo,
			String incomingzoo
	) {
		this.animal      = animal;
		this.zoo         = zoo;
		this.incomingzoo = incomingzoo;
	}

	@Override
	public int hashCode() {
		return 23;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ZooAnimals)) {
			return false;
		}

		ZooAnimals that    = (ZooAnimals) o;
		long       thisAId = this.getAnimal() == null
		                     ? 0
		                     : this.getAnimal()
		                           .getAnimalid();
		long       thatAId = that.getAnimal() == null
		                     ? 0
		                     : that.getAnimal()
		                           .getAnimalid();
		long       thisZId = this.getZoo() == null
		                     ? 0
		                     : this.getZoo()
		                           .getZooid();
		long       thatZId = that.getZoo() == null
		                     ? 0
		                     : that.getZoo()
		                           .getZooid();

		return (thisAId == thatAId) && (thisZId == thatZId);
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Zoo getZoo() {
		return zoo;
	}

	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}

	public String getIncomingzoo() {
		return incomingzoo;
	}

	public void setIncomingzoo(String incomingzoo) {
		this.incomingzoo = incomingzoo;
	}

}
