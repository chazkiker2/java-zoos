package com.lambdaschool.zoos.controllers;


import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;



@RestController
@RequestMapping(value = "/zoos")
public class ZooController {
	private final ZooService zooService;

	@Autowired
	public ZooController(ZooService zooService) {
		this.zooService = zooService;
	}

	@GetMapping(value = "/zoos",
	            produces = "application/json")
	public ResponseEntity<?> getAllZoos() {
		List<Zoo> zoos = zooService.findAllZoos();
		return new ResponseEntity<>(
				zoos,
				HttpStatus.OK
		);
	}

	@GetMapping(value = "/zoo/{zooid}",
	            produces = "application/json")
	public ResponseEntity<?> getZooById(
			@PathVariable
					long zooid
	) {
		Zoo zoo = zooService.findZoo(zooid);
		return new ResponseEntity<>(
				zoo,
				HttpStatus.OK
		);
	}

	@PostMapping(value = "/zoo",
	             consumes = "application/json",
	             produces = "application/json")
	public ResponseEntity<?> postZoo(
			@Valid
			@RequestBody
					Zoo zoo
	) {
		zoo.setZooid(0);
		zoo = zooService.save(zoo);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newZooUri = ServletUriComponentsBuilder.fromCurrentRequest()
		                                           .path("/{zooid}")
		                                           .buildAndExpand(zoo.getZooid())
		                                           .toUri();
		responseHeaders.setLocation(newZooUri);
		return new ResponseEntity<>(
				zoo,
				responseHeaders,
				HttpStatus.CREATED
		);
	}

}
