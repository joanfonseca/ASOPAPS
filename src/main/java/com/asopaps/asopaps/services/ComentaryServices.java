package com.asopaps.asopaps.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duseni.duseni.entities.Comentary;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.ComentaryRepository;

@CrossOrigin (origins = { "http://localhost:4200", "http://localhost:8100", "http://localhost:8200"  })
@RestController
public class ComentaryServices {

	
	@Autowired
	private ComentaryRepository  contributionRepository;
	
	
	@PostMapping (value = "/addComentary")
	public String addComentary(@Valid @RequestBody Comentary comentary) {
		System.out.println("hola nil");
		return JsonManager.toJson(contributionRepository.save(comentary));
	}
}
