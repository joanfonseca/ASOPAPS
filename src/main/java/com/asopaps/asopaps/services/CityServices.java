package com.asopaps.asopaps.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duseni.duseni.entities.Association;
import com.duseni.duseni.entities.City;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.CityRepository;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CityServices {
	
	
	@Autowired
	private CityRepository cityRepository;

	
	@PostMapping(value = "/addCity")
	public String addAssociation(@Valid @RequestBody City city) {
		return JsonManager.toJson(cityRepository.save(city));
	}
	
	@GetMapping(value = "/allCities")
	public String getAllCities() {
		return JsonManager.toJson(cityRepository.findAll());
	}

}
