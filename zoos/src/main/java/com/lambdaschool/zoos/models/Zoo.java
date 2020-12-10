package com.lambdaschool.zoos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@Table(name="zoos")
public class Zoo extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long zooid;
	@Column(nullable = false, unique = true)
	private String zooname;

	@OneToMany(mappedBy="animal", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value="zoo", allowSetters = true)
	private Set<ZooAnimals> animals = new HashSet<>();

	@OneToMany(mappedBy="zoo", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value="zoo")
	private List<Telephone> telephones = new ArrayList<>();

	public Zoo() {}

//	@Autowired
	public Zoo(
//			long zooid,
			String zooname
	) {
//		this.zooid   = zooid;
		this.zooname = zooname;
	}

	public long getZooid() {
		return zooid;
	}

	public void setZooid(long zooid) {
		this.zooid = zooid;
	}

	public String getZooname() {
		return zooname;
	}

	public void setZooname(String zooname) {
		this.zooname = zooname;
	}

	public Set<ZooAnimals> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<ZooAnimals> animals) {
		this.animals = animals;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

}
