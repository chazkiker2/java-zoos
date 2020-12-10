package com.lambdaschool.zoos.controllers;


import com.lambdaschool.zoos.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/telephones")
public class TelephoneController {
	private TelephoneService phoneService;

	@Autowired
	public TelephoneController(TelephoneService phoneService) {
		this.phoneService = phoneService;
	}



}
