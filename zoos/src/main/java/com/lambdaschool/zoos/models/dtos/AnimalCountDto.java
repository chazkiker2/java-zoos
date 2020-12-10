package com.lambdaschool.zoos.models.dtos;


import javax.persistence.Id;
import javax.validation.constraints.NotNull;



public class AnimalCountDto {
	@Id
	@NotNull
	private long animalid;
	@NotNull
	private String animaltype;
	@NotNull
	private int zoocount;

	public AnimalCountDto() {};

	public AnimalCountDto(
			@NotNull long animalid,
			@NotNull String animaltype,
			@NotNull int zoocount
	) {
		this.animalid   = animalid;
		this.animaltype = animaltype;
		this.zoocount   = zoocount;
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

	public int getZoocount() {
		return zoocount;
	}

	public void setZoocount(int zoocount) {
		this.zoocount = zoocount;
	}

}
